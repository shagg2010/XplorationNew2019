package com.saurabh.dada.iq.impl.designpatterns.abstractfactory;

import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Blue;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Color;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Green;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Red;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;

public class ColorFactory extends AbstractFactory {
	
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

	@Override
	Color getColor(Color.RGB rGB) {
		if (rGB == Color.RGB.RED) {
			return new Red();
		}
		else if (rGB == Color.RGB.GREEN) {
			return new Green();
		}
		else if (rGB == Color.RGB.BLUE) {
			return new Blue();
		}
		return null;
	}

}
