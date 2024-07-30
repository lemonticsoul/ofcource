package com.example.dangun.common.SecurityService;



import com.example.dangun.Member.Exception.NotFoundMemberByUsernameException;
import com.example.dangun.Member.Repository.MemberRepository;
import com.example.dangun.Member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username+"asdfasdfasdfasdf"); //null
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundMemberByUsernameException(username));

        return MemberDetails.builder()
                .member(member)
                .build();
    }




}
