package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Contact, Customer{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getName() {

            String format = String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
            return format;

        }

        @Override
        public String getPhoneNumber() {
            //String.format("+%d(%03d)%d-%d-%d", code, num / 10000000, num / 10000 % 1000, num / 100 % 100, num % 100);
            String cCode = String.valueOf(data.getCountryPhoneCode());
            StringBuilder phone = new StringBuilder(String.valueOf(data.getPhoneNumber()));
            while (phone.length() < 10){
                phone = new StringBuilder("0" + phone);
            }
            String s = new StringBuilder().append("+").append(cCode).append("(").append(phone.substring(0, 3)).append(")").append(phone.substring(3, 6)).append("-").append(phone.substring(6, 8)).append("-").append(phone.substring(8, 10)).toString();

            return s;   //For example1: +38(050)123-45-67
        }


        //Метод getCompanyName() должен делегировать полномочие методу getCompany() объекта data.
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }


    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }


    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}