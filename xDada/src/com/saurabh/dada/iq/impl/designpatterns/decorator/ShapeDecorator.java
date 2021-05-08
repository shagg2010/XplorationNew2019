package com.saurabh.dada.iq.impl.designpatterns.decorator;

import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;

public abstract class ShapeDecorator implements Shape {
	   protected Shape decoratedShape;

	   public ShapeDecorator(Shape decoratedShape){
	      this.decoratedShape = decoratedShape;
	   }

	   public void draw(){
	      decoratedShape.draw();
	   }	
	}
