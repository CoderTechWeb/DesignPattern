package org.design.creational.abstractFactory.factory;

import org.design.creational.abstractFactory.CloudServiceFactory;
import org.design.creational.abstractFactory.DataBase;
import org.design.creational.abstractFactory.Storage;
import org.design.creational.abstractFactory.VirtualMachine;
import org.design.creational.abstractFactory.azure.impl.AzureDatabase;
import org.design.creational.abstractFactory.azure.impl.AzureStorage;
import org.design.creational.abstractFactory.azure.impl.AzureVirtualMachine;

public class AzureCloudServiceFactory implements CloudServiceFactory {
    @Override
    public VirtualMachine createVirtualMachine() {
        return new AzureVirtualMachine();
    }

    @Override
    public DataBase createDatabase() {
        return new AzureDatabase();
    }

    @Override
    public Storage createStorage() {
        return new AzureStorage();
    }
}
