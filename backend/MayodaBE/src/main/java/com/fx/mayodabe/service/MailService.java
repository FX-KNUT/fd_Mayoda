package com.fx.mayodabe.service;

import com.fx.mayodabe.handler.MailHandler;
import com.fx.mayodabe.to.MailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;


@Component
public class MailService {

    private JavaMailSender mailSender;

    @Autowired
    public void setMailSender(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendMail(MailTO mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getAddress());
//        message.setFrom(""); from 값을 설정하지 않으면 application.yml의 username 값이 설정
        message.setSubject(mail.getTitle());
        message.setText(mail.getMessage());

        mailSender.send(message);
    }

    public void sendMailWithFiles(MailTO mail) throws MessagingException, IOException {
        MailHandler mailHandler = new MailHandler(mailSender);

        mailHandler.setTo(mail.getAddress());
        mailHandler.setSubject(mail.getTitle());

        String htmlContent = "<p>" + mail.getMessage() + "<p>";
        mailHandler.setText(htmlContent, true);                 // 메일 내용
        mailHandler.setAttach("루피", "static/MailImage/루피.jpg");   // 첨부파일 포함
        mailHandler.setInline("찌오", "static/MailImage/찌오.jpg");   // 이미지 삽입
        mailHandler.send();
    }
}