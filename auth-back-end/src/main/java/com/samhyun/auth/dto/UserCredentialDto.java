package com.samhyun.auth.dto;

import com.samhyun.auth.common.validate.RegexpMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialDto {

    @NotNull
    @Pattern(regexp = RegexpMap.EMAIL)
    private String email;

    @NotNull
    @Pattern(regexp =RegexpMap.PASSWORD)
    private String password;
}
