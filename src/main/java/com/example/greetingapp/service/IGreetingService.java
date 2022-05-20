package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);

    List<Greeting> getAll();

    Greeting getGreetingById(long id);

    Greeting updateGreeting(Greeting greeting);

    void delete(long id);
}