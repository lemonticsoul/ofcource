package com.example.dangun.discount.Dto.in;

import com.example.dangun.discount.Model.MemberDiscount;
import com.example.dangun.discount.Model.NotMemberDiscount;
import lombok.Builder;

import java.util.UUID;

public class IsNotMemberReqDto {


    private int discount;


    @Builder
    public NotMemberDiscount toEntity() {
        return NotMemberDiscount.builder()
                .uuid(UUID.randomUUID().toString())
                .build();
    }
}
