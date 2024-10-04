package org.design.creational.abstractFactory;

public interface CloudServiceFactory {
    VirtualMachine createVirtualMachine();
    DataBase createDatabase();
    Storage createStorage();
}
