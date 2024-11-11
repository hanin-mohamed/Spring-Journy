package com.task.ioc;

public class Square implements Shape{
    int side;
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }
}