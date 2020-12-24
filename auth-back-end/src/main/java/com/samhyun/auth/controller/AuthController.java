package com.samhyun.auth.controller;

import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.security.LoginUser;
import com.samhyun.auth.service.UserAuthService;
import com.samhyun.auth.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;

    private final UserAuthService userAuthService;

    @PostMapping("/join")
    @ApiOperation("회원 가입")
    public UserDto join(@Valid @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/principal")
    @ApiOperation("로그인 사용자 정보 조회")
    public UserDetails getLoginUser() {
        return this.userAuthService.getLoginUser();
    }

}
