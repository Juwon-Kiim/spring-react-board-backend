package com.test.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class FileEntity extends BaseTimeEntity{
    @Id @GeneratedValue
    @Column(name = "file_id")
    private Long id;
    private String originalFileName;
    private String storedFileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
}
