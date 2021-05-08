package com.saurabh.dada.iq.impl.designpatterns.abstractfactory;

import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Color;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;

public abstract class AbstractFactory {
	
	public enum FACTORY { SHAPE, COLOR};

	abstract Color getColor(Color.RGB rGB);
	abstract Shape getShape(Shape.ShapeType shapeType);

}
