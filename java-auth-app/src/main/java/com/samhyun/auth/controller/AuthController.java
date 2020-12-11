package com.samhyun.auth.controller;

import com.samhyun.auth.common.exception.InvalidUserException;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {


    private final UserService userService;

    @PostMapping("/join")
    public UserDto join(UserDto userDto) throws InvalidUserException {
        return userService.create(userDto);
    }
}
