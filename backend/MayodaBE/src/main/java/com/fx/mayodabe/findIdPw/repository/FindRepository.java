package com.fx.mayodabe.findIdPw.repository;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.mail.service.MailService;
import com.fx.mayodabe.mail.to.MailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FindRepository {

    // 의존성 주입
    private DataSource DataSource;
    private MailService mailService;
    @Autowired
    public FindRepository(DataSource DataSource, MailService mailService){
        this.DataSource = DataSource;
        this.mailService = mailService;
    }
    // id 찾기 
    public Optional<FindDto> findid(String email) throws SQLException {
        String sql = "select * from member where email = ?"; // sql문 
        // DB 연결을 위한 객체들
        Connection conn = null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        FindDto findDto = new FindDto();
        // try-catch문
        try {
            conn = DataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, email); // sql문에 1번쨰 ?에 email 넣기

            rs = ps.executeQuery(); // 객체 반환


            while (rs.next()) {
                findDto.setId(rs.getString("id")); // id set
                findDto.setEmail(rs.getString("email")); // email set
                // 출력 
                System.out.println(findDto.toString());
                // 아이디 메일 
                MailTO mailTO = new MailTO();
                mailTO.setAddress(email);
                mailTO.setTitle("서버에서 보내는 메세지 입니다.");
                mailTO.setMessage("아이디는 " + findDto.getId() + "입니다.");
                mailService.sendMail(mailTO);
                
                return Optional.of(findDto);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return Optional.empty();
    }
    public Optional<FindDto> findpw(String id, String email) throws Exception {
        String sql = "select * from member where id = ? and email = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FindDto findDto = new FindDto();
        String pass = UUID.randomUUID().toString().substring(0,8);

        try {
            conn = DataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, id); // sql문에 1번쨰 ?에 id 넣기
            ps.setString(2,email); // sql문에 2번쨰 ?에 email 넣기

            rs = ps.executeQuery();


            while (rs.next()) {
                findDto.setId(rs.getString("id"));
                findDto.setEmail(rs.getString("email"));
                findDto.setPassword(rs.getString("password"));
                
                // 임시 비밀번호 메일로 전송해주기
                MailTO mailTO = new MailTO();
                mailTO.setAddress(email);
                mailTO.setTitle("서버에서 보내는 메세지 입니다.");
                mailTO.setMessage("임시 비밀번호는 " + pass + "입니다. ");
                mailService.sendMail(mailTO);

                System.out.println(findDto.toString());

                return Optional.of(findDto);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return Optional.empty();
    }
}
