package com.example.springbootdemo.commons.utils;

import com.example.springbootdemo.commons.constants.CMSExceptionCode;
import com.example.springbootdemo.commons.exception.CMSException;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/8/10
 */
public class StringUtil {



    /**
     * 判断数字字符串
     * @param coupons
     * @throws Exception
     */
    public static void checkString(String coupons) throws Exception{
        Boolean b = false;
        if(StringUtils.isNotBlank( coupons )) {
                Pattern pattern = compile("^[-\\+]?[\\d]*$");
                b =  pattern.matcher(coupons).matches();
                if(b == false) {
                    throw new CMSException( CMSExceptionCode.VERSION_MUST_SHUZI );
                }
        }

    }
}
