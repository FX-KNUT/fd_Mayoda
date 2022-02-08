package com.fx.mayodabe.findIdPw.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FindDto {
    private String id;
    private String email;
    private String password;

    public FindDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public FindDto(String email) {
        this.email = email;
    }
}
