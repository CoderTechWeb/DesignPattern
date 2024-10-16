package org.design.creational.prototype;

public interface Document extends Cloneable{
    public Document clone();
    void printContent();
}
