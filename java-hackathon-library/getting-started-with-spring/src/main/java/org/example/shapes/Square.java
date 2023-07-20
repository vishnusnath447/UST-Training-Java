package org.example.shapes;

public class Square implements Shape{
    private Color color;
    public Square(Color color) {
        this.color = color;
    }
    @Override
    public void area() {
        System.out.println("Area Square");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Color of square: "+color);
    }
}
