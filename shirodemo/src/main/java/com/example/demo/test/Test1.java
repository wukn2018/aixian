//package com.example.demo.test;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * ***GOOD LUCK****
// *
// * @Author : Wukn
// * @Date : 2018/6/
// */
//public class Test1 {
//    private static final transient Logger log = LoggerFactory.getLogger(Test1.class);
//
//
//    public static void main(String[] args) {
//
//        Subject currentUser = SecurityUtils.getSubject();
//
//        // Do some stuff with a Session (no need for a web or EJB container!!!)
//        // 测试使用 Session
//        // 获取 Session: Subject#getSession()
//        Session session = currentUser.getSession();
//        session.setAttribute("someKey", "aValue");
//        String value = (String) session.getAttribute("someKey");
//        if (value.equals("aValue")) {
//            log.info("---> Retrieved the correct value! [" + value + "]");
//        }
//    }
//
//
//
//
//
//
//
//}
