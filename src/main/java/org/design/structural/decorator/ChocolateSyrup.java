package org.design.structural.decorator;

public class ChocolateSyrup implements  IceCream{

    private IceCream base;

    public ChocolateSyrup() {
    }

    public ChocolateSyrup(IceCream base) {
        this.base = base;
    }

    @Override
    public int getCost() {
        if(base == null) return 0;
        return base.getCost() + 25;
    }

    @Override
    public String getDescription() {
        if(base == null) return "Chocolate Syrup\n";
        return base.getDescription() + "Chocolate Syrup\n";
    }
}
