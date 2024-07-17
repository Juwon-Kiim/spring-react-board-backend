package com.test.board.service;

import com.test.board.dto.JoinDTO;
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
    @Transactional(readOnly = false)
    public Long join(JoinDTO joinDTO){
        validateDuplicateMember(joinDTO);
        Member member = new Member(joinDTO.getUsername(), bCryptPasswordEncoder.encode(joinDTO.getPass()), "ROLE_USER");
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(JoinDTO joinDTO) {
        if(memberRepository.existsByUsername(joinDTO.getUsername())){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
