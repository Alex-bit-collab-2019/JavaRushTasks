package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {
    public static void main(String[] args) {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");

        doMove(amigo, enemy);   //a
        doMove(amigo, enemy);   //a
        doMove(enemy, amigo);
        doMove(amigo, enemy);   //a
        doMove(enemy, amigo);
        doMove(amigo, enemy);   //a
        doMove(enemy, amigo);
        doMove(amigo, enemy);   //a
    }

    //public static void doMove(AbstractRobot robotFirst, AbstractRobot robotSecond) {
    public static void doMove(Robot robotFirst, Robot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        //System.out.println(robotFirst.);
        System.out.println(String.format("%s атаковал робота %s, атакована %s, защищена %s",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced));
    }
}
