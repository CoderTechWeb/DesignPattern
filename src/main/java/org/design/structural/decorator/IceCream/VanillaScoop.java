package org.design.structural.decorator.icecream;

public class VanillaScoop implements  IceCream{

    private IceCream base;

    public VanillaScoop() {
    }

    public VanillaScoop(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        if(base == null) return 0;
        return base.getCost() + 15;
    }

    @Override
    public String getDescription() {
        if(base == null) return "Vanilla Cone\n";
        return base.getDescription() + "Vanilla Cone\n";
    }
}
