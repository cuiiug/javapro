package cn.hui.javapro.design.factory;

public class ShapeFactory{
    
    public Shape getShape(String shape){

       if("CIRCLE".equals(shape)){
           return new Circle();
       }else if("RECTANGLE".equals(shape)){
           return new Rectangle();
       }else if("SQUARE".equals(shape)){
           return new Square();
       }else{
           return null;
       }


    }
}