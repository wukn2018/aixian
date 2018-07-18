package com.example.jedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 *
 * 新的时间日期Api
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DateApiDemo {


    /**
     * 1:LocalDate
     * 2:LocalTime
     * 3:LocalDateTime
     *
     */
    @Test
    public void test1() {
        //获取当前时间
        LocalDateTime time = LocalDateTime.now();
        //2018-07-10T18:28:59.885
        System.out.println(time);


        //加两天
        time.plusDays( 2 );
        //加小时
        time.plusHours( 1 );
        //加分钟
        time.plusMinutes( 12 );

        //减2天
        time.minusDays( 2 );
        //减2小时
        time.minusHours( 2 );

        //得到年
        time.getYear();
        //得到月
        time.getMonth().getValue();


        //
        LocalDateTime time1 = LocalDateTime.of( 2015,7,10,6,30,20 );
        //2015-07-10T06:30:20
        System.out.println(time1);
    }


    /**
     *时间戳 : 以Unix元年 1970年1月1日 00:00:00 到某个时间之间的毫秒值
     */
    @Test
    public void test2() {
        //默认获取的是UTC时区时差是8个小时
        Instant instant1 = Instant.now();
        OffsetDateTime of = instant1.atOffset( ZoneOffset.ofHours( 8 ) );
        System.out.println(of);


        //得到时间戳  单位是毫秒
        long l = instant1.toEpochMilli();
        System.out.println(instant1.toEpochMilli());

        //在元年的基础上加60秒
        Instant instant2 = Instant.ofEpochSecond( 60 );
        System.out.println(instant2);
    }


    /**
     *  Duration: 计算两个时间之间的间隔
        Period : 计算两个日期之间的间隔
     */
    @Test
    public void test3() {
        Instant instant1 = Instant.now();

        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }

        Instant instant2 = Instant.now();

        Duration duration = Duration.between( instant1,instant2 );
        //秒
        System.out.println(duration.getSeconds());

        //纳秒
        System.out.println(duration.getNano());
        
        //毫秒
        System.out.println(duration.toMillis());


        LocalDate localDate1 = LocalDate.now();

        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
        //获取时间之前的间隔
        LocalTime  localDate2 = LocalTime.now();
        Duration duration1 = Duration.between( localDate1,localDate2 );
        System.out.println(duration1.toMillis());
    }


    /**
     * Period : 计算两个日期之间的间隔
     */
    @Test
    public void test4() {
        LocalDate localDate1 = LocalDate.of( 2015,10,20 );
        LocalDate localDate2 = LocalDate.now();
        Period period = Period.between( localDate1,localDate2 );
        //相差的年月日
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }


    /**
     * TemporalAdjuster : 时间矫正器
     *
     */
    @Test
    public void test5() {
        LocalDateTime dateTime = LocalDateTime.now( );
        LocalDateTime time = dateTime.withDayOfMonth( 10 );
        System.out.println( time );


        //下个周二
        LocalDateTime time1 = dateTime.with( TemporalAdjusters.next( DayOfWeek.FRIDAY ) );
        System.out.println( time1 );

        //自定义: 下一个工作日
        dateTime.with( (x) -> {
            LocalDateTime localDateTime = (LocalDateTime) x;
            DayOfWeek dayOfWeek = localDateTime.getDayOfWeek( );
            if (dayOfWeek.equals( DayOfWeek.FRIDAY )) {
                localDateTime.plusDays( 3 );
                return localDateTime;
            }else if (dayOfWeek.equals( DayOfWeek.MONDAY )) {
                localDateTime.plusDays( 2 );
                return localDateTime;
            }
            return localDateTime;
        });
    }


    /**
     * DateTimeFormatter : 格式化时间或者日期
     */
    @Test
    public void test6() {
        //定义格式
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String s = localDateTime.format( dtf );
        /**
         * 20180716
         */
        System.out.println(s);




        //自定义格式
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern( "yyyy年MM月dd日 HH:mm:ss");
        /**
         * 2018年07月16日 18:00:38
         */
       String s1 =  dtf2.format( localDateTime );
       System.out.println(s1);


       //将字符串转化为时间格式
       LocalDateTime localDateTime1 = LocalDateTime.parse( s1,dtf2 );
       System.out.println(localDateTime1);


    }


    /**
     * 时区的处理
     *
     * ZoneDate
     * ZoneTime
     * ZoneDateTime
     */
    @Test
    public void test7() {
        Set<String> strings =  ZoneId.getAvailableZoneIds();
        /**
         * 显示所有时区
         * [Asia/Aden, America/Cuiaba, Etc/GMT+9, Etc/GMT+8, Africa/Nairobi]
         */
        System.out.println(strings);


        /**
         * 指定时区,构建时间
         */
        LocalDateTime time = LocalDateTime.now(ZoneId.of( "America/Cuiaba" ));
        //2018-07-16T23:10:28.350
        System.out.println(time);


        /**
         * 2018-07-16T23:17:06.158+08:00[Asia/Shanghai]
         */
        ZonedDateTime zt = time.atZone( ZoneId.of( "Asia/Shanghai" ) );
        System.out.println(zt);



    }



    @Test
    public void test8() {
        Pattern pattern = compile("^[-\\+]?[\\d]*$");
        Boolean b =  pattern.matcher("5的656的56").matches();
        System.out.println(b);
    }


    @Test
    public void test12() {
        String password = "wu1236gdfgd4586";
        System.out.println(BCrypt.gensalt());
        String s = BCrypt.hashpw( password,BCrypt.gensalt() );
        System.out.println(s);
        String s1 = "$2a$10$4YC2JRrPVJztQK/LOqqrOO9xHf1fogplRXuSV.cOda8BOxDNdeWzm";
        
        System.out.println("---------------------------------");


        Boolean b  = BCrypt.checkpw(password, s1 );
        System.out.println(b);
    }





































































}
