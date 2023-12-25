package org.design.prototype.registry;

public interface Shape extends Cloneable{
    void draw();

    Shape clone();
}
