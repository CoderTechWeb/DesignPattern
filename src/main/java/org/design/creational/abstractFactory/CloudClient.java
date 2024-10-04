package org.design.creational.abstractFactory;

import org.design.creational.abstractFactory.factory.AWSCloudServiceFactory;
import org.design.creational.abstractFactory.factory.AzureCloudServiceFactory;

public class CloudClient {
    private VirtualMachine vm;
    private Storage storage;
    private DataBase dataBase;

    public CloudClient(CloudServiceFactory factory) {
        this.vm = factory.createVirtualMachine();
        this.storage = factory.createStorage();
        this.dataBase = factory.createDatabase();
    }

    public void run(){
        vm.start();
        storage.uploadData();
        dataBase.connect();
    }

    public static void main(String[] args) {
        CloudServiceFactory awsCloudServiceFactory = new AWSCloudServiceFactory();
        CloudClient awsClient = new CloudClient(awsCloudServiceFactory);
        awsClient.run();

        System.out.println("------------");

        AzureCloudServiceFactory azureCloudServiceFactory = new AzureCloudServiceFactory();
        CloudClient azureClient = new CloudClient(azureCloudServiceFactory);
        azureClient.run();
    }
}
