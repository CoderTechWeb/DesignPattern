package org.design.creational.prototype;

public class PrototypePatternDemo {

    public static void main(String[] args) {
        DocumentManager docManager = new DocumentManager();
        docManager.addTemplate("contract", new Contract("Acme Corp", "Standard Terms"));
        docManager.addTemplate("resume", new Resume("John Doe", "Java, Spring Boot"));

        Document contractClone = docManager.createDocument("contract");
        Document resumeClone = docManager.createDocument("resume");

        contractClone.printContent();
        resumeClone.printContent();
    }
}
