package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());


        if((a > b && a < c && b < c) || (a < b && a > c && b > c)) {System.out.println(a);}    //213   231
        if((a < b && a < c && b < c) || (a > b && a > c && b > c)) {System.out.println(b);}    //123   321
        if((a < b && a < c && b > c) || (a > b && a > c && b < c)) {System.out.println(c);}    //132   312

        if((a == b && a == c && b == c) || (a == b || a == c)) {System.out.println(a);}
        else {
            if (b == c) {System.out.println(b);}
        }


    }
}
