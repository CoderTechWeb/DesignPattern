package org.design.prototype.registry;

import org.design.prototype.SimpleGreetingCard;

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
