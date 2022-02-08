package com.fx.mayodabe.findIdPw.controller;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.findIdPw.service.FindService;
import com.fx.mayodabe.mail.service.MailService;
import com.fx.mayodabe.mail.to.MailTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {
    private MailService mailService;
    private boolean result = false;

    public FindController(MailService mailService){
        this.mailService = mailService;
    }

    @GetMapping("/findid")
    public String findid(@RequestParam String email) throws Exception {
        FindDto findDto = new FindDto(email);

        FindService findService = new FindService();
        result = findService.findId(findDto);

        if(result == false)
            return "Undone successfully on findid";

        MailTO mailTO = new MailTO();
        mailTO.setAddress(email);
        mailTO.setTitle("[Mayoda] 아이디 찾기");
        mailTO.setMessage("회원님의 아이디는 " + findDto.getId() + "입니다.");

        mailService.sendMail(mailTO);

        return "done successfully on findid";
    }

    @GetMapping("/findpw")
    public String findpw(@RequestParam String id, @RequestParam String email) throws Exception{
        FindDto findDto = new FindDto(id, email);

        FindService findService = new FindService();
        result = findService.findPw(findDto);

        if(result == false)
            return "Undone successfully on findpw";

        MailTO mailTO = new MailTO();
        mailTO.setAddress(email);
        mailTO.setTitle("[Mayoda] 임시 비밀번호 발급");
        mailTO.setMessage("임시비밀번호는 " + findDto.getPassword() + "입니다.");


        mailService.sendMail(mailTO);

        return "done successfully on findpw";
    }
}
