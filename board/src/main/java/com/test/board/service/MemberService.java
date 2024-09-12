package com.test.board.service;

import com.test.board.dto.request.JoinReqDTO;
import com.test.board.entity.Member;
import com.test.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public Long join(JoinReqDTO joinReqDTO){
        validateDuplicateMember(joinReqDTO);
        Member member = new Member(joinReqDTO.getUsername(), joinReqDTO.getEmail(), bCryptPasswordEncoder.encode(joinReqDTO.getPassword()), "ROLE_USER");
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(JoinReqDTO joinReqDTO) {
        if(memberRepository.existsByEmail(joinReqDTO.getEmail())){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
