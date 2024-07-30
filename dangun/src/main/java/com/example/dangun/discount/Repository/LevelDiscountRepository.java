package com.example.dangun.discount.Repository;

import com.example.dangun.discount.Model.MemberDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelDiscountRepository extends JpaRepository<MemberDiscount,Long> {
}
