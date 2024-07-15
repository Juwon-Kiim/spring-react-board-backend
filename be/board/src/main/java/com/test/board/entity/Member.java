package com.test.board.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String username;
    private String pass;
    private String role;
    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    public Member(String username, String pass, String role) {
        this.username = username;
        this.pass = pass;
        this.role = role;
    }
}
