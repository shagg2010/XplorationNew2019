package com.saurabh.dada.iq.impl.designpatterns.GOF.creational;

import com.saurabh.dada.iq.impl.designpatterns.GOF.creational.Shape.ShapeType;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		ShapeFactory factory = ShapeFactory.getInstance();
		Shape shape = factory.getShape(ShapeType.CIRCLE);
		shape.draw();

	}

}
interface Shape {
	public enum ShapeType { RECTANGLE, SQUARE, CIRCLE};
	void draw();
}
class ShapeFactory {
	
	private static volatile ShapeFactory factory = null;

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

	public static ShapeFactory getInstance() {
		if (factory == null) { // first time lock
			synchronized (ShapeFactory.class) {
				if (factory == null) { // second time lock
					factory = new ShapeFactory();
				}
			}
		}
		return factory;
	}

}
class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
