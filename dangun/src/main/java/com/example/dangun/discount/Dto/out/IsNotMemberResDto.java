package com.example.dangun.discount.Dto.out;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IsNotMemberResDto {

    private String uuid;

    private int discount;

    private String comment;

}
