package com.javarush.task.task13.task1326;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            Scanner scanner = new Scanner(System.in);  // C:\alex\java\JavaRushTasks\test.txt

            //BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
            //String fileName = readerName.readLine(); //C:\alex\java\JavaRushTasks\test.txt

            FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream ));
            ArrayList<Integer> numbers = new ArrayList<>();


            while(reader.ready()) {
                int number = Integer.parseInt(reader.readLine());
                if (number % 2 == 0) {
                    numbers.add(number);
                }
            }
            Collections.sort(numbers);
            for (int number : numbers) {
                System.out.println(number);
            }

            reader.close();
            //fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
