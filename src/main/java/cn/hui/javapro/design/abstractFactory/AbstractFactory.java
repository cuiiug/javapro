package cn.hui.javapro.design.abstractFactory;

public abstract class AbstractFactory{
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}