package com.example.dangun.discount.Dto.out;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IsMemberResDto {
    private Long id;
    private int level;

    private int discount;

    private Long memId;

    private String comment;


    public static IsMemberResDto of(Long id, int level, int discount, Long memId, String comment){
        return IsMemberResDto
                .builder()
                .id(id)
                .level(level)
                .discount(discount)
                .comment(comment)
                .memId(memId)
                .build();

    }
}
