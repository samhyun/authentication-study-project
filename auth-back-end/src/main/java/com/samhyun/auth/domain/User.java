package com.samhyun.auth.domain;

import com.samhyun.auth.dto.UserDto;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    private String nickname;

    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date modifiedAt;

    public User(UserDto userDto) {
        if (userDto != null) {
            BeanUtils.copyProperties(userDto, this);
        }
    }

}
