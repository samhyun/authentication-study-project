package com.samhyun.auth.service;

import com.samhyun.auth.common.exception.InvalidUserException;
import com.samhyun.auth.domain.User;
import com.samhyun.auth.domain.UserRepository;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.extension.TimingExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith({MockitoExtension.class, TimingExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceUnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User savedUser = User.builder()
                .id(1)
                .email("test@test.com")
                .firstName("test")
                .lastName("hi")
                .password("testsadf")
                .nickname("test123")
                .build();

        Mockito.when(userService.save(ArgumentMatchers.any())).thenReturn(savedUser);

        Mockito.when(userService.isExistsEmail(ArgumentMatchers.anyString())).thenReturn(true);
    }

    /**
     * 회원 가입
     */
    @Test
    @DisplayName("회원 가입 테스트")
    public void joinTest() throws InvalidUserException {
//        given
        UserDto user = UserDto.builder()
                .email("test@test.com")
                .firstName("test")
                .lastName("hi")
                .password("testsadf")
                .nickname("test123")
                .build();

//        when then
        Assertions.assertEquals(1L, userService.create(user).getId());

    }

    /**
     * 이메일 중복 체크
     */
    @Test
    @DisplayName("이메일 중복 확인 테스트")
    public void testIsExistsEmail() {
//        given
        String email = "test@test.com";

//        when
        boolean isExist = userService.isExistsEmail(email);

//        then
        Assertions.assertTrue(isExist);
    }

}
