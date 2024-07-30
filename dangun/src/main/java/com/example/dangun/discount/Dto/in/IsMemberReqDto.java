package com.example.dangun.discount.Dto.in;


import com.example.dangun.discount.Model.MemberDiscount;
import com.example.dangun.discount.Model.Levels;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IsMemberReqDto {

    private int level;

    @Builder
    public MemberDiscount toEntity(Long memId) {
        return MemberDiscount.builder()
                .level(level)
                .discount(Levels.getDiscount(level))
                .memId(memId)
                .build();
    }
}
