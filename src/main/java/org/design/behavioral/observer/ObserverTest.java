package org.design.behavioral.observer;

public class ObserverTest {

    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();
        Internet internet = new Internet();

        Loan loan = new Loan("Personal Loan", 12.5f, "Standard Charterd");
        loan.registerObserver(newspaper);
        loan.registerObserver(internet);
        loan.setInterest(3.5f);

       loan.notifyObserver();
        System.out.println();
    }
}
