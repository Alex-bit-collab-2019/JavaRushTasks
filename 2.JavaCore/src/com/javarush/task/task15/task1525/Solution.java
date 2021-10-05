package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader reader = null;

        {
            try {
                //reader = new BufferedReader(new FileReader(new File("text.txt")));
                //lines= Files.readAllLines(Paths.get(Solution.class.getResource(Statics.FILE_NAME).getFile().substring(1)));

                File file = new File(Statics.FILE_NAME);
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("file not found");
            }

            try {
                String line;
                while ( (line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("file not lines");
            }
        }
    }

    public static void main(String[] args) {



        System.out.println(lines);
        //System.out.println(lines.get(0));
    }
}
