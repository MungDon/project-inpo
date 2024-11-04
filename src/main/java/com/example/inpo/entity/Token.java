package com.example.inpo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_token")
@Getter
public class Token {

    @Id
    @Column(name = "refresh_token")
    private String refreshToken;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_sid")
    private Member member;

    @Column(name = "refresh_expire_time")
    private LocalDateTime refreshExpireTime;

}
