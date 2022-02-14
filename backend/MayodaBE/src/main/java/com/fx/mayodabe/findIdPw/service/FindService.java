package com.fx.mayodabe.findIdPw.service;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.findIdPw.repository.FindRepository;
import com.fx.mayodabe.mail.service.MailService;
import com.fx.mayodabe.mail.to.MailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class FindService {
    @Autowired
    private FindRepository findRepository;
    public FindService(FindRepository FindRepository){
        this.findRepository = findRepository;
    }

    public boolean findId(String email) throws Exception{
//        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(findDto.getEmail());
//            MemberEntity userEntity = userEntityWrapper.get();
        if(findRepository.findid(email).isEmpty()){
            return false;
        }

        return true;
    }


    public boolean findPw(String id, String email) throws Exception{
//        MemberEntity member = memberRepository.findByEmail(findDto.getId()).get();
//
        if(findRepository.findpw(id,email).isEmpty()){
            return false;
        }
        return true;
    }
}
