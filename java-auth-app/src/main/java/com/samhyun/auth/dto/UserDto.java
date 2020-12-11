package com.samhyun.auth.dto;

import com.samhyun.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private long id;

    private String email;

    private String nickname;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    private Date createdAt;

    private Date modifiedAt;

    public User convertToUser() {
        return new ModelMapper().map(this, User.class);
    }
}
