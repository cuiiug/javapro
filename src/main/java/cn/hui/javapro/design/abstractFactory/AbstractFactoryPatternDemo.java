package cn.hui.javapro.design.abstractFactory;

public class AbstractFactoryPatternDemo{

    public static void main(String[] args) {
        
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取Circle 
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color  red  = colorFactory.getColor("RED");
        red.fill();
        Color blue = colorFactory.getColor("BLUE");
        blue.fill();
        Color green = colorFactory.getColor("GREEN");
        green.fill();

    }
}