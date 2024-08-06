package AWS6.APITest.api.controller;

import AWS6.APITest.api.dto.member.MemberRequest;
import AWS6.APITest.api.dto.member.MemberResponse;
import AWS6.APITest.api.dto.response.CommonResult;
import AWS6.APITest.api.dto.response.ListResult;
import AWS6.APITest.entity.Member;
import AWS6.APITest.service.MemberService;
import AWS6.APITest.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ResponseService responseService;

    @PostMapping
    public CommonResult createMember(@RequestBody MemberRequest memberRequest) {
        Member member = new Member(memberRequest.getMemberId(), memberRequest.getMemberPw());
        memberService.createMember(member);
        return responseService.getSuccessResult();
    }

    @GetMapping
    public ListResult<MemberResponse> findAllUser(){
        List<Member> members = memberService.getAllMembers();
        List<MemberResponse> memberResponseList = members.stream().map(MemberResponse::toDto).collect(Collectors.toList());
        return responseService.getListResult(memberResponseList);
    }
}
