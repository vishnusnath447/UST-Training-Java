package org.example.shapes;

public class ShapeManager {
    private Shape shape;
    private Color color;
    public void drawShape(Shape shape,Color color) {
        this.shape = shape;
        this.color = color;
    }
}
