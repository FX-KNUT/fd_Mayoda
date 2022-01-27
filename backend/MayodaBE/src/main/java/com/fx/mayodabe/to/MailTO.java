package com.fx.mayodabe.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok 사용
@Getter
@Setter
@NoArgsConstructor
public class MailTO {

    private String address;
    private String title;
    private String message;
}
