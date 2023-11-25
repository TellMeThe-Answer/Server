package com.capstone.answer.domain.member.dto;

import com.capstone.answer.domain.member.Member;

public record MemberSignUpAndLoginDto(String email, String password){
    public Member entity(){
        return Member
                .builder()
                .email(email)
                .password(password)
                .build();
    }
}
