package org.design.creational.prototype;

public class GreetingCardExample {

    public static void main(String[] args) {
        GreetingCardPrototype prototypeCard = new SimpleGreetingCard();

        GreetingCardPrototype card1 = prototypeCard.clone();
        card1.customize("Alice");
        card1.addElement("Wishing you a wonderful day!");

        GreetingCardPrototype card2 = prototypeCard.clone();
        card2.customize("Bob");
        card2.addElement("Enjoy your special moment!");

        System.out.println("Card 1:" + card1);
        card1.display();

        System.out.println("\nCard 2:"+ card2);
        card2.display();
    }
}
