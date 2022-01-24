package com.fx.mayodabe.controller;

//import 문
import com.fx.mayodabe.model.TestAPIModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러 문
@RestController
public class TestAPIController {
    // URL
    @RequestMapping("/get/test1")
    // name 파라미터 받기
    public TestAPIModel todo(@RequestParam String name)
    {
        System.out.println(name);

        // TestAPIModel 리턴하기
        return new TestAPIModel(name,"OK");
    }
}