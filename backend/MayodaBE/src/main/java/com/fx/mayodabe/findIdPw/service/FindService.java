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
    private MailService mailService;
    public FindService(FindRepository FindRepository, MailService mailService){
        this.findRepository = findRepository;
        this.mailService = mailService;
    }

    public boolean findId(String email) throws Exception{
//        Optional<MemberEntity> userEntityWrapper = memberRepository.findByEmail(findDto.getEmail());
//            MemberEntity userEntity = userEntityWrapper.get();
        if(findRepository.findid(email).isEmpty()){

            return false;
        }
//        메일 보는 내는 중 오류
//        MailTO mailTO = new MailTO();
//        FindDto findDto = new FindDto();
//        mailTO.setAddress(email);
//        mailTO.setTitle("서버에서 보내는 메세지 입니다.");
//        mailTO.setMessage("아이디는 " + findDto.getId() + "입니다.");
//
//        mailService.sendMail(mailTO);

        return true;
    }


    public boolean findPw(String id, String email) throws Exception{
//        MemberEntity member = memberRepository.findByEmail(findDto.getId()).get();
//
        if(findRepository.findid(email).isEmpty()){
            return false;
        }

//        오류
//        String pass = UUID.randomUUID().toString().substring(0,7);
//        MailTO mailTO = new MailTO();
//        FindDto findDto = new FindDto();
//        mailTO.setAddress(email);
//        mailTO.setTitle("서버에서 보내는 메세지 입니다.");
//        mailTO.setMessage("임시 비밀번호는 " + pass + "입니다. ");
//
//        mailService.sendMail(mailTO);

        return true;
    }
}
