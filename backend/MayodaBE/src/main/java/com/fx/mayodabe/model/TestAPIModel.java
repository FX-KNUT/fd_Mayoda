package com.fx.mayodabe.model;
// setter, getter 메소드
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

    public String getName()
    {
        return message;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}