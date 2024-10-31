package com.example.inpo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
@Getter
@Table(name = "tb_member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_sid")
    private Long memberSid;

    private String email;

    private String password;

    private String name;

    private String role;

    @Column(name = "oauth_id")
    private String oauthId;

}
