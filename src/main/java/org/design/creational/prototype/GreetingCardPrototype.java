package org.design.creational.prototype;

public interface GreetingCardPrototype{
    GreetingCardPrototype clone();
    void customize(String recipient);
    void addElement(String element);
    void display();
}
