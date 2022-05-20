package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// We have created this class that implements the interface so that we can use the Jpa methods.
@Service
public class GreetingServiceImpl implements IGreetingService{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //We are using the Autowired annotation so that we can use the interface methods.
    @Autowired
    private GreetingRepository greetingRepository;


    /**
     *Method to add the id and message to the repository.
     *
     * @param user - We are passing the user object
     * @return - will return the id and the message
     */
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    /**
     *  Method to get all the greetings from the list.
     * @return - will return the List of all the users.
     */
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }

    /**
     *  Method to get the greeting by the Id.
     * @param id - We will pass the id
     * @return - Will return the greeting repo of the user id.
     */
    @Override
    public Greeting getGreetingById(long id){
        return greetingRepository.findById(id).get();
    }
    /**
     * Method to edit the greeting message.
     * @param greeting - Will pass the greeting class with data in Json
     * @return -  will return the updated greeting message
     */
    @Override
    public Greeting updateGreeting(Greeting greeting) {
        if (greetingRepository.findById(greeting.getId()).isPresent())
            return greetingRepository.save(greeting);
        else
            return new Greeting(-1, " Greeting not found!");
    }
    /**
     * Method to delete the greeting by id
     * @param id -  we will pass the id to delete the greeting msg.
     */
    public void delete(long id) {
        greetingRepository.deleteById(id);
    }
}