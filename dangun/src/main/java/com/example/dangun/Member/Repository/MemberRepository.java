package com.example.dangun.Member.Repository;


import com.example.dangun.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

   Optional<Member> findByUsername(String username);
   boolean existsByUsername(String username);

   boolean existsByNickname(String nickname);
}