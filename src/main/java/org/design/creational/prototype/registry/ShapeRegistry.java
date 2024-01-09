package org.design.creational.prototype.registry;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private final Map<String, Shape> shapeMap;
    public ShapeRegistry() {
        shapeMap = new HashMap<>();
        shapeMap.put("circle", new Circle());
        shapeMap.put("Square", new Square());
    }
    public void addShape(String key, Shape shape) {
        shapeMap.put(key, shape);
    }
    public Shape getShape(String key) {
        Shape shape = shapeMap.get(key);
        if (shape != null) return shape.clone();
        return null;
    }

}
