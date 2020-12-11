package com.samhyun.auth.service;

import com.samhyun.auth.common.exception.InvalidUserException;
import com.samhyun.auth.domain.User;
import com.samhyun.auth.domain.UserRepository;
import com.samhyun.auth.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원 가입
     *
     * @param userDto user dto
     * @return saved user entity
     */
    public UserDto create(UserDto userDto) throws InvalidUserException {
        User user = userDto.convertToUser();
        if (user.validate()) {
            return this.save(user).convertToDto();
        } else {
            throw new InvalidUserException();
        }
    }

    protected User save(User user) {
        return this.userRepository.save(user);
    }

    /**
     * 이미 가입된 이메일인지 체크
     *
     * @param email 체크 할 이메일
     * @return 존재 여부
     */
    public boolean isExistsEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
