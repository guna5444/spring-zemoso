package com.luv2code.springdemo;

public class MyApp {
    public static void main(String[] args) {
        //create the object
        //use the object
        Coach theCoach = new TrackCoach();
        System.out.println(theCoach.getDailyWorkout());
    }
}
