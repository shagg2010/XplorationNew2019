package com.saurabh.dada.iq.impl.designpatterns.abstractfactory;

import com.saurabh.dada.iq.impl.designpatterns.abstractfactory.AbstractFactory.FACTORY;

public class FactoryProducer {
	
	private FactoryProducer(){
		//Sigleton class
	}
	
	public static AbstractFactory getFactory(AbstractFactory.FACTORY choice) {
		
		if (choice == FACTORY.SHAPE) {
			return ShapeFactory.getInstance();

		} else if (choice == FACTORY.COLOR) {
			return ColorFactory.getInstance();
		}
		return null;
	}

}
