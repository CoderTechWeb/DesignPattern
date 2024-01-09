package org.design.creational.singleton;

public class Student {
    private String name;
    private int rollNo;
    private String section;

    private static volatile Student instance;

    private Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public static Student getInstance() {
        if(instance == null) {
            synchronized (Student.class) {
                if (instance == null) {
                    instance = new Student();
                }
            }
        }
        return instance;
    }
}
