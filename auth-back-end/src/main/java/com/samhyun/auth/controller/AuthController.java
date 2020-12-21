package com.samhyun.auth.controller;

import com.samhyun.auth.common.exception.InvalidUserDataException;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.service.UserService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("회원 가입")
    public UserDto join(@RequestBody UserDto userDto) throws InvalidUserDataException {
        return userService.create(userDto);
    }

    @GetMapping("/email/exists")
    @ApiOperation("이메일 존재 여부 확인")
    public boolean isExists(@RequestParam String email) {

        return userService.isValidEmail(email);
    }

    @GetMapping("/test")
    @ApiOperation("테스트")
    public String test() {
        return "";
    }
}