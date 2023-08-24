package com.naveen.controller;

import com.naveen.dto.User;
import com.naveen.event.UserEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserEventPublisher userEventPublisher;

    @GetMapping(value = "/")
    public User getUsers() {
        final User build = User.builder().id("1232").name("naveen").build();
        userEventPublisher.publishUserCreatedEvent(build);
        return build;
    }
}
