package com.example.blog.se;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/3/25 18:12
 * @describe
 */
public class test1 {


    public static void main(String[] args) {
        int a = 1;
        int b = 12;
        if (a > 0 & b < a) {
            System.out.println(true);
        }
        if (a > 0 && b < a) {
            System.out.println(true);
        }
        if (a < 0 || b > a) {
            System.out.println(true);
        }
        if (a < 0 || b > a) {
            System.out.println(true);
        }
    }

}
