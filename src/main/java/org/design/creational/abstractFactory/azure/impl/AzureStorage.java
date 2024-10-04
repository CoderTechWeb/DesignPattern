package org.design.creational.abstractFactory.azure.impl;

import org.design.creational.abstractFactory.Storage;

public class AzureStorage implements Storage {
    @Override
    public void uploadData() {
        System.out.println("Uploading data to Azure storage...");
    }
}
