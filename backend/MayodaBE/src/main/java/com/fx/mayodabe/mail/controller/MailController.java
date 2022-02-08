package com.fx.mayodabe.mail.controller;

import com.fx.mayodabe.mail.service.MailService;
import com.fx.mayodabe.mail.to.MailTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;


@RestController
@RequestMapping("/mail")
public class MailController {

    private MailService mailService;

    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    // 텍스트만 발송 가능한 URL
    @GetMapping("/send")
    public MailTO sendTestMail(String email) {
        MailTO mailTO = new MailTO();

        mailTO.setAddress(email);
        mailTO.setTitle("김성은님이 발송한 이메일입니다.");
        mailTO.setMessage("hello world, I'm testing this logic");

        mailService.sendMail(mailTO);

        return mailTO;
    }

    // 텍스트와 첨부파일 모두 발송 가능한 URL
    @GetMapping("/fileSend")
    public MailTO sendTestFileEmail(String email) throws MessagingException, IOException {
        MailTO mailTO = new MailTO();

        mailTO.setAddress(email);
        mailTO.setTitle("김성은님이 발송한 이메일입니다.");
        mailTO.setMessage("hello world, I'm testing this logic");

        mailService.sendMailWithFiles(mailTO);

        return mailTO;
    }
}