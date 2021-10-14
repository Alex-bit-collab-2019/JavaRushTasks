package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        String filePath1 = null;    // "C:\alex\java\JavaRushTasks\JavaRushTasks\test.txt"
        String filePath2 = null;    // "C:\alex\java\JavaRushTasks\JavaRushTasks\test2.txt"
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            filePath1 = reader.readLine();
            filePath2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file1 = new File(filePath1);
            FileReader fr1 = new FileReader(file1);
            BufferedReader reader1 = new BufferedReader(fr1);
            String lineFile1;

            while ((lineFile1 = reader1.readLine())!= null) {
                allLines.add(lineFile1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file2 = new File(filePath2);
            FileReader fr2 = new FileReader(file2);
            BufferedReader reader2 = new BufferedReader(fr2);
            String lineFile2;

            while ((lineFile2 = reader2.readLine()) != null) {
                forRemoveLines.add(lineFile2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

    }
}
