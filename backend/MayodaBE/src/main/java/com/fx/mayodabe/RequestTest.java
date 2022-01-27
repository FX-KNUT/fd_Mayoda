package com.fx.mayodabe;

import com.fx.mayodabe.Dto.AuthorDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestTest {

    @GetMapping("/test")
    public AuthorDto test(){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setAuthor("김성은");
        authorDto.setMessage("testOK");

        return authorDto;
    }
}
