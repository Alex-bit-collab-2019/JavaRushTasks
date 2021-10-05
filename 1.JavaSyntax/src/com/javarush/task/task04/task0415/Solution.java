package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String aString = reader.readLine();
        int a = Integer.parseInt(aString);

        String bString = reader.readLine();
        int b = Integer.parseInt(bString);

        String cString = reader.readLine();
        int c = Integer.parseInt(cString);

        if (a + b > c){
            System.out.println("Треугольник существует.");
        } else if (b + c > a){
            System.out.println("Треугольник существует.");
        } else if (a +c > b){
            System.out.println("Треугольник существует.");
        } else {
            System.out.println("Треугольник не существует.");
        }

    }
}