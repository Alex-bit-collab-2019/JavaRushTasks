package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements  Comparable <Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

        Beach beach1 = new Beach ("Palm Beach", 50, 5);
        Beach beach2 = new Beach ("Miami Beach", 100, 4);
        Beach beach3 = new Beach ("Deerfield Beach", 100, 4);
        Beach beach4 = new Beach ("Miami II", 25, 4);

        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach2.compareTo(beach3));
        System.out.println(beach3.compareTo(beach4));
        System.out.println(beach1.compareTo(beach4));

        System.out.println(beach2.compareTo(beach1));
        System.out.println(beach3.compareTo(beach2));
        System.out.println(beach4.compareTo(beach3));
        System.out.println(beach4.compareTo(beach1));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result = Float.compare(o.getDistance(), getDistance()) + Integer.compare(getQuality(), o.getQuality());
        return result;
    }

}
