package com.example.dangun.Member.Service;



import com.example.dangun.Member.Dto.MemberSignupDto;
import com.example.dangun.Member.Exception.DuplicationMemberNicknameException;
import com.example.dangun.Member.Exception.DuplicationMemberUsernameException;
import com.example.dangun.Member.Repository.MemberRepository;
import com.example.dangun.Member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    public Long createMenber(MemberSignupDto memberSignUpDto) {


        if (memberRepository.existsByUsername(memberSignUpDto.getUsername()))
            throw new DuplicationMemberUsernameException(memberSignUpDto.getUsername());
        if (memberRepository.existsByNickname(memberSignUpDto.getNickname()))
            throw new DuplicationMemberNicknameException(memberSignUpDto.getNickname());

        Member member =memberSignUpDto.toEntity();
        member.passwordEncode(encoder);

        memberRepository.save(member);

        return member.getId();

    }
}
