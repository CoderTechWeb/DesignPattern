package org.design.creational.prototype.registry;

public interface Shape extends Cloneable{
    void draw();

    Shape clone();
}
