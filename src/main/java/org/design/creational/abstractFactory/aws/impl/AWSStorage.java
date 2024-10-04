package org.design.creational.abstractFactory.aws.impl;

import org.design.creational.abstractFactory.Storage;

public class AWSStorage implements Storage {
    @Override
    public void uploadData() {
        System.out.println("Uploading data to AWS storage...");
    }
}
