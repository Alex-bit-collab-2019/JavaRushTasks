package com.javarush.task.task03.task0319;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Предсказание на будущее
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sName = reader.readLine(); //читаем строку с клавиатуры
        String sNomer1 = reader.readLine(); //читаем строку с клавиатуры
        String sNomer2 = reader.readLine(); //читаем строку с клавиатуры

        int Nomer1 = Integer.parseInt(sNomer1);  //преобразовываем строку в число.
        int Nomer2 = Integer.parseInt(sNomer2);  //преобразовываем строку в число.
        System.out.println(sName + " получает " + Nomer1 + " через " + Nomer2 + " лет.");


    }
}
