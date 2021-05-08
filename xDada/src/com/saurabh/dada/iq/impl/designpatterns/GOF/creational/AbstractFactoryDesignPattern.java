package com.saurabh.dada.iq.impl.designpatterns.GOF.creational;

import com.saurabh.dada.iq.impl.designpatterns.GOF.creational.AbstractFactory.FACTORY;
import com.saurabh.dada.iq.impl.designpatterns.GOF.creational.Color.RGB;
import com.saurabh.dada.iq.impl.designpatterns.GOF.creational.Shape.ShapeType;

public class AbstractFactoryDesignPattern {

	public static void main(String[] args) {
		AbstractFactory factory = null;
		
		try{
			factory = FactoryProducer.getFactory(FACTORY.COLOR);
			Color c1 = factory.getColor(RGB.RED);
			c1.fill();
			
			factory = FactoryProducer.getFactory(FACTORY.SHAPE);
			Shape s1 = factory.getShape(ShapeType.RECTANGLE);
			s1.draw();
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

}
abstract class AbstractFactory {
	
	public enum FACTORY { SHAPE, COLOR};

	abstract Color getColor(Color.RGB rGB);
	abstract Shape getShape(Shape.ShapeType shapeType);

}
class FactoryProducer {
	
	private FactoryProducer(){
		//Sigleton class
	}
	
	public static AbstractFactory getFactory(AbstractFactory.FACTORY choice) {
		
		if (choice == FACTORY.SHAPE) {
			return ShapeFactory1.getInstance();

		} else if (choice == FACTORY.COLOR) {
			return ColorFactory.getInstance();
		}
		return null;
	}
}

class ShapeFactory1 extends AbstractFactory {
	
	private static volatile ShapeFactory1 factory = null;
	
	private ShapeFactory1(){
		//Singleton class
	}

	// use getShape method to get object of type shape
	public Shape getShape(Shape.ShapeType shapeType) {
		if (shapeType == Shape.ShapeType.CIRCLE) {
			return new Circle();

		} else if (shapeType == Shape.ShapeType.RECTANGLE) {
			return new Rectangle();

		} else if (shapeType == Shape.ShapeType.SQUARE) {
			return new Square();
		}
		return null;
	}

	public static ShapeFactory1 getInstance() {
		if (factory == null) { // first time lock
			synchronized (ShapeFactory.class) {
				if (factory == null) { // second time lock
					factory = new ShapeFactory1();
				}
			}
		}
		return factory;
	}

	Color getColor(Color.RGB rGB) {
		return null;
	}

}

class ColorFactory extends AbstractFactory {
	
	private static volatile ColorFactory factory = null;
	
	private ColorFactory(){
		//Singleton class
	}

	public Shape getShape(Shape.ShapeType shapeType) {
		return null;
	}

	public static ColorFactory getInstance() {
		if (factory == null) { // first time lock
			synchronized (ColorFactory.class) {
				if (factory == null) { // second time lock
					factory = new ColorFactory();
				}
			}
		}
		return factory;
	}

	Color getColor(Color.RGB rGB) {
		if (rGB == Color.RGB.RED) {
			return new Red();
		}
		else if (rGB == Color.RGB.GREEN) {
			return new Green();
		}
		return null;
	}

}
interface Color {
	public enum RGB { RED, GREEN};
	void fill();
}
class Green implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}
class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}