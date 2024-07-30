package com.example.dangun.discount.Service;


import com.example.dangun.discount.Dto.in.IsMemberReqDto;
import com.example.dangun.discount.Dto.in.IsNotMemberReqDto;
import com.example.dangun.discount.Dto.out.IsMemberResDto;
import com.example.dangun.discount.Dto.out.IsNotMemberResDto;
import com.example.dangun.discount.Model.FasterCoupon;
import com.example.dangun.discount.Model.MemberDiscount;
import com.example.dangun.discount.Model.NotMemberDiscount;
import com.example.dangun.discount.Repository.FasterCouponRepository;
import com.example.dangun.discount.Repository.FasterDiscountRepository;
import com.example.dangun.discount.Repository.LevelDiscountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter

public class DiscountService {

    private final FasterDiscountRepository fasterDiscountRepository;

    private final LevelDiscountRepository levelDiscountRepository;
    private final FasterCouponRepository fasterCouponRepository;
    public IsMemberResDto savediscount(IsMemberReqDto isMemberReqDto, Long id,String username) {

       MemberDiscount memberDiscount = isMemberReqDto.toEntity(id);
       MemberDiscount saveLeveldiscount=levelDiscountRepository.save(memberDiscount);

       return IsMemberResDto.
               of(saveLeveldiscount.getId(),
                       saveLeveldiscount.getDiscount(),
                       saveLeveldiscount.getLevel(),
                       saveLeveldiscount.getMemId(),
                       username+"님 "+saveLeveldiscount.getDiscount()+"% 할인쿠폰이 발급되었습니다.");
    }

    public void savefasterdiscount() {

        FasterCoupon fasterCoupon=FasterCoupon.builder()
                .count(5)
                .build();

        fasterCouponRepository.save(fasterCoupon);
        fasterDiscountRepository.deleteAll();

    }

    public IsNotMemberResDto getisnotmemberdiscount(IsNotMemberReqDto isNotMemberReqDto) {

        NotMemberDiscount notmemberDiscount =isNotMemberReqDto.toEntity();

        fasterDiscountRepository.save(notmemberDiscount);
        List<FasterCoupon> fasterCoupon=fasterCouponRepository.findAll();


        if (fasterCoupon.get(0).getCount()<=0){
            fasterCouponRepository.deleteAll();
            throw new RuntimeException("선착순 쿠폰 마감했습니다!");
        }

        fasterCoupon.get(0).setCount(fasterCoupon.get(0).getCount()-1);
        fasterCouponRepository.save(fasterCoupon.get(0));


        return IsNotMemberResDto.builder()
                .uuid(notmemberDiscount.getUuid())
                .discount(10)
                .comment(notmemberDiscount.getUuid()+"님 10% 선착순 쿠폰 발급 성공하였습니다.").build();

    }
}
