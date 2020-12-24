package com.samhyun.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.service.UserAuthService;
import com.samhyun.auth.service.UserService;
import com.samhyun.auth.service.UserServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Stream;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {AuthController.class})
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService userService;

    @MockBean
    private UserAuthService userAuthService;

    static final Logger log = LoggerFactory.getLogger(UserServiceTest.class.getName());

    private static Stream<UserDto> invalidUserProvider() {
        return Stream.of(
                UserDto.builder()
                        .email("test12@test.com")
                        .firstName("삼1현")
                        .lastName("김")
                        .password("test45@")
                        .nickname("testasdfas")
                        .mobile("0120123123")
                        .build(),
                UserDto.builder()
                        .email("test12@test.com")
                        .firstName("samhyunsamhyunsamhyun")
                        .lastName("k")
                        .password("test45@")
                        .nickname("testasdfas")
                        .mobile("0120123123")
                        .build()

        );
    }

    private static Stream<UserDto> validUserProvider() {
        return Stream.of(
                UserDto.builder()
                        .email("test12@test.com")
                        .firstName("삼현")
                        .lastName("김")
                        .password("test45@")
                        .nickname("testasdfas")
                        .mobile("0120123123")
                        .build(),
                UserDto.builder()
                        .email("test12@test.com")
                        .firstName("samhyunsamhyunsamhyun")
                        .lastName("kim")
                        .password("test45@")
                        .nickname("testasdfas")
                        .mobile("0120123123")
                        .build()

        );
    }

    @ParameterizedTest
    @MethodSource("invalidUserProvider")
    @DisplayName("유효하지 않은 사용자 데이터로 회원가입 api 콜 테스트")
    public void join_api_invalid_user_call_test(UserDto userDto) throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/auth/join")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(userDto))
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @ParameterizedTest
    @MethodSource("validUserProvider")
    @DisplayName("유효한 사용자 데이터로 회원가입 api 콜 테스트")
    public void join_api_valid_user_call_test(UserDto userDto) throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/auth/join")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(userDto))
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }


}
