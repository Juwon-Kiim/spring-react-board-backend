package com.test.board.controller;

import com.test.board.dto.request.JoinReqDTO;
import com.test.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinReqDTO joinReqDTO){
        Long id = memberService.join(joinReqDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

}
