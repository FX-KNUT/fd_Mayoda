package com.fx.mayodabe.findIdPw.repository;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FindRepository {

    // 의존성 주입
    private DataSource DataSource;
    @Autowired
    public FindRepository(DataSource DataSource){
        this.DataSource = DataSource;
    }



    public Optional<FindDto> findid(String email) throws SQLException {
        String sql = "select * from member where email = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, email); // sql문에 1번쨰 ?에 email 넣기

            rs = ps.executeQuery();


            while (rs.next()) {
                FindDto findDto = new FindDto();
                findDto.setId(rs.getString("id"));
                findDto.setEmail(rs.getString("email"));
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
        try {
            conn = DataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, id); // sql문에 1번쨰 ?에 email 넣기
            ps.setString(2,email);

            rs = ps.executeQuery();


            while (rs.next()) {
                FindDto findDto = new FindDto();
                findDto.setId(rs.getString("id"));
                findDto.setEmail(rs.getString("email"));
                findDto.setPassword(rs.getString("password"));
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
