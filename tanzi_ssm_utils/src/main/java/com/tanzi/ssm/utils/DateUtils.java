package com.tanzi.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String date2String(Date date, String patt){
        SimpleDateFormat sdf =new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    public static Date string2Date(String str,String patt) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse =sdf.parse(str);
        return parse;
    }
    }