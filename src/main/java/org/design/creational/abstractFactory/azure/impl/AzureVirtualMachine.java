package org.design.creational.abstractFactory.azure.impl;

import org.design.creational.abstractFactory.VirtualMachine;

public class AzureVirtualMachine implements VirtualMachine {

    @Override
    public void start() {
        System.out.println("Starting Azure Virtual Machine...");
    }
}
