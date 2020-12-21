package com.samhyun.auth.dto;

import com.samhyun.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private long id;

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String mobile;

    private Date createdAt;

    private Date modifiedAt;

    public UserDto(User user) {
        if (user != null) {
            BeanUtils.copyProperties(user, this, "password");
        }
    }
}
