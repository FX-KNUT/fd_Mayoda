package com.fx.mayodabe.Dto;

public class AuthorDto {
    private String message;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getAuthor() { return author; }
    public String getMessage() {
        return message;
    }
}
