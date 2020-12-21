package com.samhyun.auth.dto;

import com.samhyun.auth.common.validate.RegexpMap;
import com.samhyun.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    private long id;

    @NotNull
    @Pattern(regexp = RegexpMap.EMAIL)
    private String email;


    @NotNull
    @Pattern(regexp = RegexpMap.NICKNAME)
    private String nickname;

    @NotNull
    @Pattern(regexp =RegexpMap.PASSWORD)
    private String password;

    @NotNull
    @Pattern(regexp = RegexpMap.NAME)
    private String firstName;

    @NotNull
    @Pattern(regexp = RegexpMap.NAME)
    private String lastName;

    @NotNull
    @Pattern(regexp = RegexpMap.MOBILE)
    private String mobile;

    private Date createdAt;

    private Date modifiedAt;

    public UserDto(User user) {
        if (user != null) {
            BeanUtils.copyProperties(user, this, "password");
        }
    }
}
