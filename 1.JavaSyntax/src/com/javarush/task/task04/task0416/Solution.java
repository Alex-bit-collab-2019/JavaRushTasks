package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String minutesString = reader.readLine();
        double minutes = Integer.parseInt(minutesString);

        minutes = minutes % 5;
        System.out.println(minutes);

        if (minutes <= 3) {
            System.out.println("зелёный");
        } else  if (minutes <= 4){
            System.out.println("желтый");
        } else {
            System.out.println("красный");
            }



    }
}