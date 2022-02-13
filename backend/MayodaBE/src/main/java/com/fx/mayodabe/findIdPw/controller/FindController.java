package com.fx.mayodabe.findIdPw.controller;

import com.fx.mayodabe.Config;
import com.fx.mayodabe.findIdPw.dto.FindDto;

import com.fx.mayodabe.findIdPw.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class FindController {

    FindService findService;

    public FindController(FindService findService) {
        this.findService = findService;
    }

    @GetMapping("/findid")
    public String findid(@RequestParam String email) throws Exception {

        if(findService.findId(email)){
            return "done successfully on findid";
        }
        return "Undone successfully on findid";
    }

    @GetMapping("/findpw")
    public String findpw(@RequestParam String id, @RequestParam String email) throws Exception {
        if(findService.findPw(id,email)){
            return "done successfully on findpw";
        }
        return "Undone successfully on findpw";
    }
}
