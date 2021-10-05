package com.javarush.task.task04.task0412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное и отрицательное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberString = reader.readLine(); //читаем строку с клавиатуры
        int number = Integer.parseInt(numberString); //преобразовываем строку в число.

        if (number == 0) {
            System.out.println(number);
        } else if (number > 0){
            System.out.println(number * 2);
        } else {
            System.out.println(number + 1);
        }


    }
}