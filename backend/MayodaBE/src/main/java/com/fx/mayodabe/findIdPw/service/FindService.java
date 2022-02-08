package com.fx.mayodabe.findIdPw.service;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.signuplogin.domain.entity.MemberEntity;
import com.fx.mayodabe.signuplogin.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class FindService {
    @Autowired
    MemberRepository memberRepository;

    public boolean findId(FindDto findDto) throws Exception{
//        MemberEntity member;
//
//        member = memberRepository.findByEmail(findDto.getEmail()).get();
        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(findDto.getEmail());
        MemberEntity userEntity = userEntityWrapper.get();
        if(userEntity == null)
            return false;
        else{
            findDto.setId(userEntity.getId());
            return true;
        }
    }

    public boolean findPw(FindDto findDto) throws Exception{
        MemberEntity member = memberRepository.findByEmail(findDto.getId()).get();

        if(findDto.getId().equals(member.getId())){
            findDto.setPassword(UUID.randomUUID().toString().substring(0,8));
            return true;
        }
        else
            return false;
    }
}
