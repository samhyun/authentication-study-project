package com.samhyun.auth.controller;


import com.samhyun.auth.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/valid/email/{email}")
    @ApiOperation("이메일 유효성 체크")
    public boolean isValidEmail(@PathVariable String email) {
        return userService.isValidEmail(email);
    }

    @GetMapping("/valid/nickname/{nickname}")
    @ApiOperation("닉네임 유효성 체크")
    public boolean isValidNickname(@PathVariable String nickname) {
        return userService.isValidNickname(nickname);
    }

}
