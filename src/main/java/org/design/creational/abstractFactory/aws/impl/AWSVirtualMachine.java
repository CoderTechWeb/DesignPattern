package org.design.creational.abstractFactory.aws.impl;

import org.design.creational.abstractFactory.VirtualMachine;

public class AWSVirtualMachine implements VirtualMachine {
    @Override
    public void start() {
        System.out.println("Starting AWS Virtual Machine...");
    }
}
