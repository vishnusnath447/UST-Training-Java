package org.example.shapes;

public class Color {
    private String color;

    public Color(){
        System.out.println("Color Constructor");
    }
    public Color(String color) {
        this.color = color;
        System.out.println("Constructor: "+color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
