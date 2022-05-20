package com.example.greetingapp.service;

import com.example.greetingapp.entity.Greeting;
import com.example.greetingapp.entity.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
}
