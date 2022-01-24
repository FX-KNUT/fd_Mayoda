package com.fx.mayodabe.model;
// set, get 메소드
public class TestAPIModel
{
    // 변수 선언하기 
    private String message;
    private String name;
    
    public TestAPIModel(String name, String message)
    {
        this.name = name;
        this.message = message;
    }
    // name get 하기
    public String getName()
    {
        return message;
    }
    // name set 하기
    public void setName(String name)
    {
        this.name = name;
    }
    //message get 하기
    public String getMessage()
    {
        return message;
    }
    // message set 하기
    public void setMessage(String message)
    {
        this.message = message;
    }
}