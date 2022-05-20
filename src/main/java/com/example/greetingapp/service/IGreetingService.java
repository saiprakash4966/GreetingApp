package com.example.greetingapp.service;

iimport com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);

    List<Greeting> getAll();

    Greeting getGreetingById(long id);
}