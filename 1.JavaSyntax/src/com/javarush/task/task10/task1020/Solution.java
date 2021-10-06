package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 10 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        //int[] array = {10, 2, 10, 3, 1, 2, 5};
        //System.out.println(Arrays.toString(array));
        boolean needIteration = true;
        while (needIteration) {
        	needIteration = false;
        	for (int i = 1; i < array.length; i++) {
        		if (array[i] < array[i - 1]) {
        			swap(array, i, i-1);
        			needIteration = true;
        		}
        	}
        }
        //System.out.println(Arrays.toString(array));
    }
    private static void swap(int[] array, int ind1, int ind2) {
            int tmp = array[ind1];
            array[ind1] = array[ind2];
            array[ind2] = tmp;
    }
//END    
}
