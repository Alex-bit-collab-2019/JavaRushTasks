package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
*/


//«Инициализация класса происходит при первом обращении к классу.
//
//        Инициализация класса - присвоение значений всем статическим  переменным и инициализация статических блоков.
//
//        Статический блок будет выполнен один раз, при первом обращении к классу, еще до того как класс будет
//        использоваться, то есть до создания экземпляров, вызова статических методов, обращения к полям.
//
//        Нестатический блок срабатывает каждый раз при создании нового объекта.
//        Равнозначные блоки исполняются сверху вниз.
//
//        Порядок инициализации блоков и переменных:
//        1. Статические блоки и переменные родителя;
//        2. Статические блоки и переменные наследника;
//        3. Нестатические блоки и переменные родителя;
//        4. Конструктор родителя;
//        5. Нестатические блоки и переменные наследника;
//        6. Конструктор наследника.
//
//        Пункты 3-6 выполняются только и при каждом создании экземпляра» © yurii.
//        2. Исправить нужно два момента: второй статический блок можно снести, а вызов метода из него перекинуть
//        в начало первого.
//        3. В конце поменять местами распечатки с новой строки: сначала число объекта, а затем его имя.
//        4. Всё получится!
//

public class Solution {
    static {
        init();
    }
    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";



    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);

    }
}
