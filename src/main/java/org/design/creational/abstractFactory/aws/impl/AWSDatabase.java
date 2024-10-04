package org.design.creational.abstractFactory.aws.impl;

import org.design.creational.abstractFactory.DataBase;

public class AWSDatabase implements DataBase {
    @Override
    public void connect() {
        System.out.println("Connected to AWS Database...");
    }
}
