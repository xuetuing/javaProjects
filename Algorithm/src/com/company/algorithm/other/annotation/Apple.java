package com.company.algorithm.other.annotation;

public class Apple {
    @FruitName("apple")
    private String appleName;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public void display() {
        System.out.println("appleName: " + appleColor);
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.display();
    }
}
