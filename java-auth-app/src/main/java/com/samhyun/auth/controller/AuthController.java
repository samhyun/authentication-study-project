package com.samhyun.auth.controller;

import com.samhyun.auth.common.exception.InvalidUserException;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/email/{email}/exists")
    public boolean isExists(@PathVariable String email) {

        return userService.isExistsEmail(email);
    }
}
