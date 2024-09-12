package com.test.board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginReqDTO {
    private String email;
    private String password;
}
