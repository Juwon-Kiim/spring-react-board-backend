package com.test.board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinReqDTO {
    private String username;
    private String email;
    private String password;
}
