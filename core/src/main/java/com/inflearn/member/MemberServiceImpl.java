package com.inflearn.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // null이면 NPE발생 하기 때문에 구현 객체를 선택해줘야한다,
    // 생성자 주입
    private final MemberRepository memberRepository; // 오로지 MemberRepository 인터페이스만 있다. DIP를 지킨다. 구체적인 MemberServiceImpl은 모른다.


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
