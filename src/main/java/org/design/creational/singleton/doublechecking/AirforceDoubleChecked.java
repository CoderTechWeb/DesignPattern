package org.design.creational.singleton.doublechecking;

public class AirforceDoubleChecked {

    private volatile static AirforceDoubleChecked instance;

    private AirforceDoubleChecked() {}

    public static AirforceDoubleChecked getInstance() {
        if(instance == null) {
            synchronized(AirforceDoubleChecked.class) {
                if(instance == null) {
                    instance = new AirforceDoubleChecked();
                }
            }
        }
        return instance;
    }
}

class client {
    public static void main(String[] args) {
        AirforceDoubleChecked obj = AirforceDoubleChecked.getInstance();
        AirforceDoubleChecked obj2 = AirforceDoubleChecked.getInstance();
        System.out.println(obj == obj2);
    }
}