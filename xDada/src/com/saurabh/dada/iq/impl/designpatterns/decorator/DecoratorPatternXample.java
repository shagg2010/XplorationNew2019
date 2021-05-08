package com.saurabh.dada.iq.impl.designpatterns.decorator;

import com.saurabh.dada.iq.impl.designpatterns.factory.Circle;
import com.saurabh.dada.iq.impl.designpatterns.factory.Rectangle;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;

public class DecoratorPatternXample {
	
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

}
