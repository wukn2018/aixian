package com.example.demo.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 *
 *  加密
 */
@Component
public class BCryptUtils {


    /**
     * BCrypt 加密
     * @return
     */
    public String getBCrypt(String password) {
        return Optional.ofNullable( password )
                .map( (x) -> BCrypt.hashpw( password,BCrypt.gensalt() ) )
                .orElse( "加密参数不能为空" );
    }



    /**
     * BCrypt 解密
     * @param password1   用户输入的密码
     * @param password2   加密后的密码
     * @return
     */
    public Boolean catBCrypt(String password1 , String password2) {
        Boolean b  = BCrypt.checkpw(password1, password2 );
        return b ;
    }






    /**
     * MD5  加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public String EncoderByMd5(String str) throws Exception {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }














}
