package org.example.org.entity;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private Address address;
    private MemberAccount memberAccount;

    private List<Member> memberList = new ArrayList<>();

    public Member(){}

    public Member(int memberId, String name, Address address, MemberAccount memberAccount) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.memberAccount = memberAccount;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MemberAccount getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(MemberAccount memberAccount) {
        this.memberAccount = memberAccount;
    }

    void openAnAccount(int memberId,String name,Address address){
        if(memberList.stream().anyMatch(m -> m.memberId==memberId)){
            System.out.println("Member Exists!");
        }
        else {
            Member newMember = new Member();
            MemberAccount newMemberAccount = new MemberAccount(memberId,null);
            newMember.setMemberId(memberId);
            newMember.setAddress(address);
            newMember.setName(name);
            newMember.setMemberAccount(newMemberAccount);
            memberList.add(newMember);
            System.out.println("Member Added!");
        }
    }
}
