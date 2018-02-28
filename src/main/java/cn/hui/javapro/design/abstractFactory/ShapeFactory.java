package cn.hui.javapro.design.abstractFactory;

public class ShapeFactory extends AbstractFactory{

	@Override
	public  Color getColor(String color) {
       return null;
	}

	@Override
	public Shape getShape(String shape) {
        if("CIRCLE".equalsIgnoreCase(shape)){
            return new Circle();
         } else if("RECTANGLE".equalsIgnoreCase(shape)){
            return new Rectangle();
         } else if(("SQUARE".equalsIgnoreCase(shape))){
            return new Square();
         }else{
             return null;
         }
	}

}