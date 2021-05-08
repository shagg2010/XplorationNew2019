package com.saurabh.dada.iq.impl.designpatterns.abstractfactory;

import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Color;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.Color.RGB;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape.ShapeType;
import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.AbstractFactory.FACTORY;

public class AbstractFactoryPatternXample {

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
