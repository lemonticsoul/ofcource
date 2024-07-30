package com.example.dangun.discount.Controller;


import com.example.dangun.common.SecurityService.MemberDetails;
import com.example.dangun.discount.Dto.in.IsMemberReqDto;
import com.example.dangun.discount.Dto.in.IsNotMemberReqDto;
import com.example.dangun.discount.Dto.out.IsMemberResDto;
import com.example.dangun.discount.Dto.out.IsNotMemberResDto;
import com.example.dangun.discount.Service.DiscountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;


    @PostMapping("/ismember")
    public ResponseEntity<?> isMemberDiscount(@RequestBody IsMemberReqDto isMemberReqDto,
    @AuthenticationPrincipal MemberDetails memberDetails) {

        System.out.println(memberDetails.getUsername()+"hi");

        IsMemberResDto isMemberResDto=discountService.savediscount(isMemberReqDto,memberDetails.getMemberId(),memberDetails.getUsername());

        return ResponseEntity.ok(isMemberResDto);


    }

    @PostMapping("/isnotmember")
    //not member 쿠폰 !
    public ResponseEntity<?> saveFasterCoupon(){
        System.out.println("ㅎㅇ");
        discountService.savefasterdiscount();
        return ResponseEntity.ok("쿠폰 발급 되었습니다!");
    }

    @PostMapping("/saveisnotmember")
    //not member 쿠폰 발급!
    public ResponseEntity<?> isnotMemberDiscount(@RequestBody IsNotMemberReqDto isNotMemberReqDto){

        IsNotMemberResDto isNotMemberResDto=discountService.getisnotmemberdiscount(isNotMemberReqDto);

        return ResponseEntity.ok(isNotMemberResDto);

    }



}
