package org.example.shapes;

public class Circle implements Shape{
    private Color color;
    public Circle(Color color) {
        this.color = color;
    }
    @Override
    public void area() {
        System.out.println("Area of Circle");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Color of circle: "+color);
    }
}
