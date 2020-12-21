package com.samhyun.auth.service;

import com.samhyun.auth.common.exception.InvalidDataExceptionStatus;
import com.samhyun.auth.common.exception.InvalidUserDataException;
import com.samhyun.auth.domain.User;
import com.samhyun.auth.dto.UserDto;
import com.samhyun.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Date;
import java.util.regex.Pattern;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

    private static final Pattern NICKNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9가-힣]([._-](?![._-])|[a-zA-Z0-9가-힣]){1,18}[a-zA-Z0-9가-힣]$");

    /**
     * 회원 가입
     *
     * @param userDto user dto
     * @return saved user entity
     */
    public UserDto create(@Valid UserDto userDto) throws InvalidUserDataException {
        return new UserDto(this.save(new User(userDto)));
    }

    protected User save(User user) {
        if (!validate(user)) {
            throw new InvalidUserDataException(InvalidDataExceptionStatus.INVALID_USER_DATA);
        }
        return this.userRepository.save(prepareForSave(user));
    }

    private User prepareForSave(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());
        return user;
    }

    private boolean validate(User user) {
        return this.isValidEmail(user.getEmail()) &&
                this.isValidNickname(user.getNickname());
    }


    /**
     * 이메일 유효성 체크
     *
     * @param email 체크 할 이메일
     * @return 존재 여부
     */
    public boolean isValidEmail(String email) {
        if (EMAIL_PATTERN.matcher(email).matches()) {
            if (this.userRepository.existsByEmail(email)) {
                throw new InvalidUserDataException(InvalidDataExceptionStatus.EXISTS_EMAIL);
            } else {
                return true;
            }
        } else {
            throw new InvalidUserDataException(InvalidDataExceptionStatus.INVALID_EMAIL_FORMAT);
        }
    }

    /**
     * 닉네임 유효성 체크
     *
     * @param nickname 체크할 닉네임
     * @return 존재 여부
     */
    public boolean isValidNickname(String nickname) {
        if (NICKNAME_PATTERN.matcher(nickname).matches()) {
            if (this.userRepository.existsByNickname(nickname)) {
                throw new InvalidUserDataException(InvalidDataExceptionStatus.EXISTS_NICKNAME);
            } else {
                return true;
            }
        } else {
            throw new InvalidUserDataException(InvalidDataExceptionStatus.INVALID_NICKNAME_FORMAT);
        }
    }

}
