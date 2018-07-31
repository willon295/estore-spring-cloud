package com.briup.estore;

import java.util.Date;

/**
 * Created By willon
 *
 * @author willon
 * @version 1.0
 * 联系方式： willon295@163.com
 * @since 18-7-31
 */
public class TestTime {

    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
