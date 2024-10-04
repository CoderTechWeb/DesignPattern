package org.design.creational.singleton.notthreadsafe;

//Not thread safe
public class Airforce {

    private static Airforce instance = null;

    private Airforce(){
    }

    public static Airforce getInstance(){
        if(instance == null) {
            instance = new Airforce();
        }
        return instance;
    }
}

class client {
    public static void main(String[] args) {
        Airforce  airforce = Airforce.getInstance();
        Airforce airforce2 = Airforce.getInstance();
        System.out.println(airforce == airforce2);
    }
}
