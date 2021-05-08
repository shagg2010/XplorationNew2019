package com.saurabh.dada.iq.impl.designpatterns.factory;

import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape.ShapeType;

public class FactoryPatternXample {

	public static void main(String[] args) {
		try{
			ShapeFactory factory = ShapeFactory.getInstance();
			Shape shape = factory.getShape(ShapeType.CIRCLE);
			shape.draw();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
