package com.javarush.task.task19.task1903;

public class TestPhone {
    public static void main(String[] args) {
        String cCode = "33";
        String phone = "71112233";
        while (phone.length() < 10){
            phone = "0" + phone;
        }
        String s = new StringBuilder().append("+").append(cCode).append("(").append(phone.substring(0, 3)).append(")").append(phone.substring(3, 6)).append("-").append(phone.substring(6, 8)).append("-").append(phone.substring(8, 10)).toString();

        //For example1: +38(050)123-45-67
        System.out.println(s);
    }
}
