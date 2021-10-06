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
        if (args.length == 0) {
            return;
        }
        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        addPerson(args);
                    }
                    break;
                case "-u":
                    synchronized (allPeople) {
                        updatePerson(args);
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        deletePerson(args);
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        printPerson(args);
                    }
                    break;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
        //args = new String[]{"-c", "Василий", "м", "15/04/1990", "Алена", "ж", "08/05/1996", "Алена", "ж", "08/05/1996", "Алена", "ж", "08/05/1996"};
        //args = new String[] {"-u", "0", "Александр", "м", "21/07/1987", "1", "Елена", "ж", "08/09/1993"};
        //args = new String[] {"-d", "0", "1"};
        //args = new String[] {"-i", "0", "1"};


    //-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
    public static void addPerson(String[] args) throws ParseException{
        for(int i = 0; i <= args.length-3; i=i+3){
            if (args[0].equals("-c")) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dateFormat = null;
                try {
                    dateFormat =  format.parse(args[i+3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (args[i+2].equals("м")) {
                    allPeople.add(Person.createMale(args[i+1], dateFormat));
                }
                if (args[i+2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[i+1], dateFormat));
                }
                System.out.println(allPeople.size()-1);
            }
            //System.out.println(i);
        }
        //System.out.println(allPeople.size()); //проверяем сколько добавилось человек в базу
    }




        //-i - выводит на экран информацию о всех людях с заданными id: name sex bd
        public static void printPerson(String[] args) {
            for(int i = 0; i < args.length-1; i++){
                if (args[0].equals("-i")) {
                    int id = Integer.parseInt(args[i+1]);
                    // format SimpleDateFormat  Locale.ENGLISH
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String dateUnit = dateFormat.format(allPeople.get(id).getBirthDate());
                    String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";

                    System.out.println(allPeople.get(id).getName() + " " + sex + " " + dateUnit);
                    //System.out.println(i);
                }
            }
        }


        //-u - обновляет соответствующие данные людей с заданными id
        public static void updatePerson(String[] args) throws ParseException{
            for(int i = 0; i <= args.length-3; i=i+4){
                if (args[0].equals("-u")) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateFormat = null;
                    int id = Integer.parseInt(args[i+1]);

                    try {
                        dateFormat = format.parse(args[i+4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Person person = Person.createMale(args[i+2], dateFormat);
                    //if (args1[3].equals("м")) {
                    if (args[i+3] == "м") {
                        allPeople.set(id, person);
                        person.setSex(Sex.MALE);
                        //System.out.println(args1[3]);
                    }
                    //if (args1[3].equals("ж")) {
                    if (args[i+3] == "ж") {
                        allPeople.set(id, person);
                        person.setSex(Sex.FEMALE);
                    }
                    // System.out.println(allPeople.get(Integer.parseInt(args[i+1])).getName()); //проверка что значение изменилось
                }
            }
        }



        //-d - производит логическое удаление человека с id, заменяет все его данные на null
        public static void deletePerson(String[] args) {
            for(int i = 0; i < args.length-1; i++){
                if (args[0].equals("-d")) {
                    //allPeople.remove(Integer.parseInt(args[1]));
                    //System.out.println("This unit delete");
                    Person person = Person.createMale(null, null);
                    person.setSex(null);

                    allPeople.set(Integer.parseInt(args[i+1]), person);
                    // System.out.println(i);
                }
            }
        }




}
