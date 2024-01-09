package org.design.creational.prototype.registry;

public class Circle implements  Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public Shape clone() {
        return new Circle();
    }
}
