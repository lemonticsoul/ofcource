package com.example.dangun.discount.Repository;

import com.example.dangun.discount.Model.FasterCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FasterCouponRepository extends JpaRepository<FasterCoupon,Long> {



}
