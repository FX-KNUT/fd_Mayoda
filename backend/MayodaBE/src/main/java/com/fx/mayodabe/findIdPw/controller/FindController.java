package com.fx.mayodabe.findIdPw.controller;
import com.fx.mayodabe.findIdPw.dto.FindDto;
import com.fx.mayodabe.findIdPw.service.FindService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {

    private FindService FindService;

    @Autowired
    public FindController(FindService FindService) {
        this.FindService = FindService;
    }

    FindDto findDto = new FindDto();

    @GetMapping("/findid")
    public String findid(@RequestParam String email) throws Exception {
            
        if(FindService.findId(email)){
            return "done successfully on findid ";
        }
        return "Undone successfully on findid";
    }

    @GetMapping("/findpw")
    public String findpw(@RequestParam String id, @RequestParam String email) throws Exception {

        if(FindService.findPw(id,email)){
            return "done successfully on findpw";
        }
        return "Undone successfully on findpw";
    }
}
