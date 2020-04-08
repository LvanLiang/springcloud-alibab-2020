package com.liang;

import java.time.ZonedDateTime;

/**
 * @author Liangxp
 * @date 2020/4/8 15:12
 */
public class TimeTest {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
