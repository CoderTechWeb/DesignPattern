package org.design.creational.singleton;

public class Main {

    public static void main(String[] args) {
        Student student = Student.getInstance();
        Student student1 = Student.getInstance();

        System.out.println(student);
        System.out.println(student1);
    }
}
