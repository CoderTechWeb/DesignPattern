package org.design.creational.abstractFactory.factory;

import org.design.creational.abstractFactory.CloudServiceFactory;
import org.design.creational.abstractFactory.DataBase;
import org.design.creational.abstractFactory.Storage;
import org.design.creational.abstractFactory.VirtualMachine;
import org.design.creational.abstractFactory.aws.impl.AWSDatabase;
import org.design.creational.abstractFactory.aws.impl.AWSStorage;
import org.design.creational.abstractFactory.aws.impl.AWSVirtualMachine;

public class AWSCloudServiceFactory implements CloudServiceFactory {
    @Override
    public VirtualMachine createVirtualMachine() {
        return new AWSVirtualMachine();
    }

    @Override
    public DataBase createDatabase() {
        return new AWSDatabase();
    }

    @Override
    public Storage createStorage() {
        return new AWSStorage();
    }
}
