package org.design.prototype.registry;

public class PrototypeRegistryExample {

    public static void main(String[] args) {
        ShapeRegistry shapeRegistry = new ShapeRegistry();

        Shape circle = shapeRegistry.getShape("circle");
        circle.draw();

        Shape square = shapeRegistry.getShape("Square");
        square.draw();

        shapeRegistry.addShape("triangle", new Triangle());
        Shape triangle = shapeRegistry.getShape("triangle");
        if (triangle != null) triangle.draw();


    }
}
