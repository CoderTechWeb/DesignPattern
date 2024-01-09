package org.design.creational.prototype.registry;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }

    @Override
    public Shape clone() {
        return new Square();
    }
}
