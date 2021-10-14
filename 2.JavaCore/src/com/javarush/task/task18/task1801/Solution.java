package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

//            1. Создаём буферизированный ридер, который считывает с клавиатуры имя файла и сохраняет его в строку.
//            2. Создаём Файловый поток и передаём в его конструктор строку с именем файла.
//            3. Заводим целочисленную переменную для максимального байта.
//            4. Заводим шарманку цикл пока поток доступен, то внутри цикла считываем байт и заносим его во временную целочисленную переменную.
//            5. Далее проверяем, если прочитанный байт больше, чем значение максимального, то максимальный = прочитанный.
//            6. После цикла распечатываем максимальный байт и закрываем потоки.
//            7. Всё получится!

public class Solution {
    public static void main(String[] args) throws Exception {
        // C:\alex\java\JavaRushTasks\JavaRushTasks\test.txt
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int maxByte = Integer.MIN_VALUE;
        while(fileInputStream.available() > 0) {
            int readByte = fileInputStream.read();
            if (readByte > maxByte) maxByte = readByte;
        }
        fileInputStream.close();

    System.out.print(maxByte);

    }
}
