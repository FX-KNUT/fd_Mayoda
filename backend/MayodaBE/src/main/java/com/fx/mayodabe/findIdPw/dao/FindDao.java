package com.fx.mayodabe.findIdPw.dao;

import com.fx.mayodabe.findIdPw.dto.FindDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class FindDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private DataSource ds;
    @Autowired
    public FindDao(DataSource ds){
        this.ds = ds;
    }

    FindDto findDto;
    @Autowired
    public FindDao(FindDto findDto){
        this.findDto = findDto;
    }

    public FindDto findid(String email) throws SQLException {
        String sql = "select * from member where email = ?";
        conn = ds.getConnection();
        ps = conn.prepareStatement(sql);

        ps.setString(1, email);

        rs = ps.executeQuery();
        while(rs.next()){
            findDto.setId(rs.getString("id"));
            findDto.setEmail(rs.getString("email"));
        }
        return findDto;
    }
    public FindDto findpw(String id, String email) throws SQLException {
        String sql = "select * from member where id = ? and email = ?";
        conn = ds.getConnection();
        ps = conn.prepareStatement(sql);

        ps.setString(1, id);
        ps.setString(2, email);

        rs = ps.executeQuery();
        while(rs.next()){
            findDto.setId(rs.getString("id"));
            findDto.setEmail(rs.getString("email"));
            findDto.setPassword(rs.getString("password"));
        }
        return findDto;
    }
}
