package com.example.greetingapp.controller;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // We use Autowired annotation to inject the GreetingService service via the interface
    @Autowired
    private IGreetingService iGreetingService;

    /**
     * Method using GET to pass the name to the User and then to the Service layer.
     * @param name - Will pass the name
     * @return - Will return the counter and user name
     * URL : http://localhost:8081/greeting/home?name=Tom
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return iGreetingService.addGreeting(user);
    }

    /**
     *  Method using Get to pass the firstname and lastname and set it using the setters
     *  Then the call the service layer and add the user to repository
     * @param firstName
     * @param lastName
     * @return
     * URL : http://localhost:8081/greeting/fullname?firstName=Tom&lastName=Thomas
     */
    @GetMapping("/fullname")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "first") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "last") String lastName ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return iGreetingService.addGreeting(user);
    }


}