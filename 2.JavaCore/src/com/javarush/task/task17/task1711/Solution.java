package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        args = new String[]{"-c", "Василий", "м", "15/04/1990", "Алена", "ж", "08/05/1996"};
        //args = new String[] {"-u", "0", "Александр", "м", "21/07/1987", "1", "Елена", "ж", "08/09/1993"};
        //args = new String[] {"-d", "0", "1"};
        //args = new String[] {"-i", "0", "1"};


        //String[] args1 = new String[]{"-c", "Миронов", "м", "15/04/1990"};
        //String[] args1 = new String[]{"-r", "0"};
        //String[] args = new String[]{"-u", "0", "Сергей", "м", "25/05/1995"};
        //String[] args1 = new String[]{"-d", "0"};


        //-c add unit
        if (args[0].equals("-c")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFormat = null;
            try {
                dateFormat =  format.parse(args[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], dateFormat));
            }
            if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], dateFormat));
            }
            System.out.println(allPeople.size()-1);
        }
        //-r print unit
        if (args[0].equals("-r")) {
            int id = Integer.parseInt(args[1]);
            // format SimpleDateFormat  Locale.ENGLISH
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String dateUnit = dateFormat.format(allPeople.get(id).getBirthDate());
            String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";

            System.out.println(allPeople.get(id).getName() + " " + sex + " " + dateUnit);
        }
        //-u update unit
        if (args[0].equals("-u")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateFormat = null;
            int id = Integer.parseInt(args[1]);

            try {
                dateFormat = format.parse(args[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Person person = Person.createMale(args[2], dateFormat);
            //if (args1[3].equals("м")) {
            if (args[3] == "м") {
                allPeople.set(id, person);
                person.setSex(Sex.MALE);
                //System.out.println(args1[3]);
            }
            //if (args1[3].equals("ж")) {
            if (args[3] == "ж") {
                allPeople.set(id, person);
                person.setSex(Sex.FEMALE);
            }
            //System.out.println(allPeople.get(Integer.parseInt(args1[1])).getName()); //проверка что значение изменилось
        }
        //-d remove unit
        if (args[0].equals("-d")) {
            //allPeople.remove(Integer.parseInt(args[1]));
            //System.out.println("This unit delete");
            Person person = Person.createMale(null, null);
            person.setSex(null);

            allPeople.set(Integer.parseInt(args[1]), person);
        }

    }
}
