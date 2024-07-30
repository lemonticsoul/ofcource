package com.example.dangun.discount.Repository;

import com.example.dangun.discount.Model.NotMemberDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FasterDiscountRepository extends JpaRepository<NotMemberDiscount,Long> {
}
