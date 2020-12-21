package com.samhyun.auth.service;

import com.samhyun.auth.common.exception.InvalidUserDataException;
import com.samhyun.auth.domain.User;
import com.samhyun.auth.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Rollback
@Transactional
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    static final Logger log = LoggerFactory.getLogger(UserServiceTest.class.getName());

    private static Stream<UserDto> userProvider() {
        return Stream.of(
                UserDto.builder()
                        .email("test12@test.com")
                        .firstName("test")
                        .lastName("hi")
                        .password("testsadf")
                        .nickname("testasdfas")
                        .mobile("0120123123")
                        .build()
        );
    }

    /**
     * 회원 가입
     */
    @ParameterizedTest
    @MethodSource("userProvider")
    @DisplayName("회원 가입 테스트")
    public void joinTest(UserDto user) throws InvalidUserDataException {
//        when
        UserDto savedUser = userService.create(user);
        log.info("savedUser : {} ", user);
//        then
        Assertions.assertNotEquals(0L, savedUser.getId());
    }
}
