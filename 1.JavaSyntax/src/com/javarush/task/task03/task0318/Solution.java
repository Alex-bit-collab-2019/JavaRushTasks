package com.javarush.task.task03.task0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
План по захвату мира
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sName = reader.readLine(); //читаем строку с клавиатуры
        String sAge = reader.readLine(); //читаем строку с клавиатуры

        int name = Integer.parseInt(sName);  //преобразовываем строку в число.
        int nAge = Integer.parseInt(sAge);  //преобразовываем строку в число.
        System.out.println(name + " захватит мир через" + nAge + "лет. Му-ха-ха!");
    }
}
