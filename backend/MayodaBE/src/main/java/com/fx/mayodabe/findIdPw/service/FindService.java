package com.fx.mayodabe.findIdPw.service;

import com.fx.mayodabe.findIdPw.dao.FindDao;
import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.signuplogin.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class FindService {
    @Autowired
    MemberRepository memberRepository;
    private FindDao findao;
    public FindService(FindDao finddao){
        this.findao = finddao;
    }

    @Autowired
    private FindDto findDto;
    public FindService(FindDto findDto){
        this.findDto = findDto;
    }

    public boolean findId(String email) throws Exception{
//        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(findDto.getEmail());
//            MemberEntity userEntity = userEntityWrapper.get();
        if (findao.findid(email) != null){
            return true;
        }
        return false;
    }

    public boolean findPw(String id, String email) throws Exception{
//        MemberEntity member = memberRepository.findByEmail(findDto.getId()).get();

        if(findao.findpw(id, email) != null){
            return true;
        }
        return false;
    }
}
