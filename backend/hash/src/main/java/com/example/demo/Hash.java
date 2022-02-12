package com.example.demo;

import com.example.demo.HashConfig;
import org.springframework.beans.factory.annotation.Value;

public class Hash {
    @Value("${hash.SALT}")
    private String SALT;

    private String pw;
    private int pwArray[] = new int[60]; // pw을 60자로 축약하기 위해 크기가 60인 정수형 배열 생성
    private String output = ""; // 해시펑션 아웃풋

    public String digest(String pw) {
        this.pw = pw + SALT; // 보안을 위해 기존 pw에 SALT를 추가함

        hashing(this.pw);
        return output;
    }

    private void hashing(String pw) {  // 보안을 위해 private로 설정
        int index = 0;
        for(String strPw : pw.split("")) {  // pw를 문자 하나씩 쪼갬
            int intPw = strPw.charAt(0);      // 각 문자를 char으로 변환하고, int형 변수인 intPw에 저장
            pwArray[index % 60] += intPw; // pwArray 배열의 특정 인덱스(index를 60으로 나눈 나머지)의 값에 intPw을 더함
            index++;
        }

        index = 0;
        for(int intPw : pwArray) {
            intPw = (intPw * (index + 5)) % 127;  // pwArray 배열의 각 정수가 33보다 크거나 같고, 127보다 작도록 조정
            if (intPw < 33)                   // 아스키코드표에 의하면 '영문자와 숫자'가 33에서 126 사이에 위치해 있기 때문
                intPw += 33;
            output += String.valueOf((char)intPw); // 정수를 char, String으로 차례대로 형변환하여 output에 추가
            index++;
        }
    }

}