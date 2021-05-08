package com.saurabh.dada.iq.impl.designpatterns.abstractfactory;

import com.saurabh.dada.iq.impl.designpatterns.factory.Circle;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Color;
import com.saurabh.dada.iq.impl.designpatterns.factory.Rectangle;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;
import com.saurabh.dada.iq.impl.designpatterns.factory.Square;

public class ShapeFactory extends AbstractFactory {
	
	private static volatile ShapeFactory factory = null;
	
	private ShapeFactory(){
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

	@Override
	Color getColor(Color.RGB rGB) {
		return null;
	}

}
