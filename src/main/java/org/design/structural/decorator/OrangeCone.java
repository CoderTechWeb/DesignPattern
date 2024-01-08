package org.design.structural.decorator;

public class OrangeCone implements  IceCream{

    private IceCream base;

    public OrangeCone() {
    }

    public OrangeCone(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        if(base == null) return 0;
        return base.getCost() + 10;
    }

    @Override
    public String getDescription() {
        if(base == null) return "Orange Cone\n";
        return base.getDescription() + "Orange Cone\n";
    }
}
