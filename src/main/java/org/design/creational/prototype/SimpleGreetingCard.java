package org.design.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class SimpleGreetingCard implements GreetingCardPrototype {

    private final List<String> elements;
    SimpleGreetingCard(){
        this.elements = new ArrayList<>();
    }
    private SimpleGreetingCard(List<String> elements) {
        this.elements = new ArrayList<>(elements);
    }
    @Override
    public void customize(String recipient) {
        elements.add("Dear " + recipient + ",");
    }
    @Override
    public void addElement(String element) {
        elements.add(element);
    }
    
    @Override
    public GreetingCardPrototype clone() {
        return new SimpleGreetingCard(this.elements);
    }
    @Override
    public void display() {
        for (String element : elements) {
            System.out.println(element);
        }
    }
}
