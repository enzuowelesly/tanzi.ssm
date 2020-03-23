package com.tanzi.ssm.utils;

import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
    public  static  String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password ="tanzi";
        System.out.println(encodePassword(password));
    }
}
