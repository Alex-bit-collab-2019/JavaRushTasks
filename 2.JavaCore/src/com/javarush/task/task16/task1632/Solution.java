package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread1 my1 = new Thread1();
        Thread2 my2 = new Thread2();
        Thread3 my3 = new Thread3();
        Thread4 my4 = new Thread4();
        Thread5 my5 = new Thread5();

        threads.add(my1);
        threads.add(my2);
        threads.add(my3);
        threads.add(my4);
        threads.add(my5);

        // не включать по условию задачи
        //my1.start();
        //my2.start();
        //my3.start();
        //my4.start();
        //my5.start();
    }
    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        public Thread1() {
        }
        public void run () {
            while (true){
            }
        }
    }

    public static class Thread2 extends Thread {

        public Thread2() {
        }
        public void run () {
            try {
                Thread.sleep(1000);
                interrupt();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println(e);
            }
        }
    }

    public static class Thread3 extends Thread {

        public Thread3() {
        }
        public void run () {
            while(true){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        public static volatile boolean isStop = false;
        @Override
        public void run(){
            while (!isStop) {
            }
        }
        public void showWarning() {
            isStop = true;
        }
    }

    public static class Thread5 extends Thread {
//        public Thread5 (String name) {
//            super(name);
//        }
        public Thread5 () {
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            int sum = 0;
            while (scanner.hasNextInt()){
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }
}