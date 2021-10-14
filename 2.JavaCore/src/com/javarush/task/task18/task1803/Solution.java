package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

// int[] byteCountArray = new int[256]; - создаётся массив размером в 256 элементов. Почему 256? Потому что байт
// может принять 256 различный значений (2 в восьмой степени).
//Так вот, значение считанного байта - это индекс этого массива. А в самом массиве хранятся количество повторов.
// То-есть, если значение очередного байта = 56, то мы на единицу увеличим byteCountArray[56].
//Строчка byteCountArray[fileInputStream.read()] += 1; увеличивает на 1 значение в массиве с индексом, равным
// считанному байту.
//Потом нам надо просто посмотреть, какой элемент в массивве наибольший - его индекс и будет тот самый байт с
// наибольшим количеством повторов.
//Это решение остроумное, но требует мысленного усилия для понимания - потому что у нас индекс - не просто
// абстрактный индекс для счёта, а соответствует некоему осмысленному значению - байту.


public class Solution {
    public static void main(String[] args) throws Exception {

        // C:\alex\java\JavaRushTasks\JavaRushTasks\test.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int[] byteCountArray = new int[256];
        while(fileInputStream.available() > 0) {
            byteCountArray[fileInputStream.read()] ++;
        }
        fileInputStream.close();

        // находим максимальное количество повторений какого-либо байта в файле
        int maxCount = 0;
        for(int byteCount : byteCountArray){
            if(byteCount > maxCount) maxCount = byteCount;
        }

        //соберем все байты в список с максимальным числом повторов
        ArrayList<Integer> listResult = new ArrayList<>();
        for (int i = 0; i < byteCountArray.length; i++){
            if (byteCountArray[i] == maxCount) listResult.add(i);
        }

        //выведем на экран результат отбора
        for (int byteN : listResult){
            System.out.print(byteN + " ");
        }

    }
}
