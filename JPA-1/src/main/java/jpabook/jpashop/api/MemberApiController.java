package jpabook.jpashop.api;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<Member> membersV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result memberV2() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);
    }

    /**
     * {} json을 컬렉션이나 배열 타입으로 바로나가면 더이상 json 데이터 추가가 힘들기때문에
     * 감싸줘야한다.[추가불가(배열이라) data...] -> { 추가가능 [data..]}
     * 기존
     * [
     *    count = 1 -> 추가 불가능 배열이기때문
     *   "name" : "hello"
     * ]
     * 수정
     * {
     *      count = 0 -> 추가가능
     *     data: [
     *      "name" :"hello"
     *     ]
     * }
     *
     * @param <T>
     */
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }
    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponseDto updateMemberResponse(@PathVariable("id") Long id,
                                                     @RequestBody @Valid UpdateMemberRequestDto request) {
        memberService.update(id,request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponseDto(id,findMember.getName());
    }


    @Data
    @AllArgsConstructor
    static class UpdateMemberResponseDto {
        @NotEmpty
        private Long id;
        private String name;
    }

    @Data
    static class UpdateMemberRequestDto {
        @NotEmpty
        private String name;
    }


    @Data
    static class CreateMemberRequest {
        private String name;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

}
