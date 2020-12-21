package com.samhyun.auth.service;

import com.samhyun.auth.common.exception.InvalidDataExceptionStatus;
import com.samhyun.auth.common.exception.InvalidUserDataException;
import com.samhyun.auth.domain.User;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.extension.TimingExtension;
import com.samhyun.auth.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Stream;

@ExtendWith({MockitoExtension.class, TimingExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceUnitTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

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

        Mockito.when(userRepository.save(ArgumentMatchers.any())).thenReturn(savedUser);
        Mockito.when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("testasfa");
    }


    private static Stream<UserDto> userProvider() {
        return Stream.of(
                UserDto.builder()
                        .email("test@test.com")
                        .firstName("test")
                        .lastName("hi")
                        .password("testsadf")
                        .nickname("test123")
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
//        when then
        Assertions.assertEquals(1L, userService.create(user).getId());
    }


    private static Stream<String> invalidEmailProvider() {
        return Stream.of(
                "test@test.com.",
                "test1235@test..co",
                "test@",
                "@naver.com"
        );
    }

    private static Stream<String> validEmailProvider() {
        return Stream.of(
                "test@test.com",
                "test1235@test.com"
        );
    }

    /**
     * 이메일 유효성 체크 - (유효한 형식의 중복된 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validEmailProvider")
    public void testValidExistsEmail(String email) {
        Mockito.when(userRepository.existsByEmail(email)).thenReturn(true);

        InvalidUserDataException exception = Assertions.assertThrows(InvalidUserDataException.class, () -> userService.isValidEmail(email));
        Assertions.assertEquals(InvalidDataExceptionStatus.EXISTS_EMAIL, exception.getStatus());
    }

    /**
     * 이메일 유효성 체크 - (유효한 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validEmailProvider")
    public void testValidNotExistsEmail(String email) {
        Mockito.when(userRepository.existsByEmail(email)).thenReturn(false);

        Assertions.assertTrue(userService.isValidEmail(email));
    }

    /**
     * 이메일 유효성 체크 - (유효한 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("invalidEmailProvider")
    public void testInvalidEmail(String email) {
        InvalidUserDataException exception = Assertions.assertThrows(InvalidUserDataException.class, () -> userService.isValidEmail(email));

        Assertions.assertEquals(InvalidDataExceptionStatus.INVALID_EMAIL_FORMAT, exception.getStatus());
    }


    private static Stream<String> invalidNicknameProvider() {
        return Stream.of(
                "a",
                "ab",
                ".홍길동",
                "홍길동!@"
        );
    }

    private static Stream<String> validNicknameProvider() {
        return Stream.of(
                "홍길동",
                "test"
        );
    }


    /**
     * 닉네임 유효성 체크 - (유효한 형식의 중복된 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validNicknameProvider")
    public void testValidExistsNickname(String nickname) {
        Mockito.when(userRepository.existsByNickname(nickname)).thenReturn(true);

        InvalidUserDataException exception = Assertions.assertThrows(InvalidUserDataException.class, () -> userService.isValidNickname(nickname));
        Assertions.assertEquals(InvalidDataExceptionStatus.EXISTS_NICKNAME, exception.getStatus());
    }

    /**
     * 이메일 유효성 체크 - (유효한 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("validNicknameProvider")
    public void testValidNotExistsNickname(String nickname) {
        Mockito.when(userRepository.existsByNickname(nickname)).thenReturn(false);

        Assertions.assertTrue(userService.isValidNickname(nickname));
    }

    /**
     * 이메일 유효성 체크 - (유효한 이메일)
     */
    @ParameterizedTest(name = "#{index} - Run test with username = {0}")
    @MethodSource("invalidNicknameProvider")
    public void testInvalidNickname(String nickname) {
        InvalidUserDataException exception = Assertions.assertThrows(InvalidUserDataException.class, () -> userService.isValidNickname(nickname));

        Assertions.assertEquals(InvalidDataExceptionStatus.INVALID_NICKNAME_FORMAT, exception.getStatus());
    }
}