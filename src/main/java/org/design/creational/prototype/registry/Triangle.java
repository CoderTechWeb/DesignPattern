package org.design.creational.prototype.registry;

public class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Traingle");
    }
    @Override
    public Shape clone() {
        return new Triangle();
    }
}
