package org.design.creational.abstractFactory.azure.impl;

import org.design.creational.abstractFactory.DataBase;

public class AzureDatabase implements DataBase {
    @Override
    public void connect() {
        System.out.println("Connecting to Azure Database");
    }
}
