package com.saurabh.dada.iq.impl.designpatterns.facade;

import com.saurabh.dada.iq.impl.designpatterns.factory.Circle;
import com.saurabh.dada.iq.impl.designpatterns.factory.Rectangle;
import com.saurabh.dada.iq.impl.designpatterns.factory.Shape;
import com.saurabh.dada.iq.impl.designpatterns.factory.Square;

public class ShapeMaker {
	   private Shape circle;
	   private Shape rectangle;
	   private Shape square;

	   public ShapeMaker() {
	      circle = new Circle();
	      rectangle = new Rectangle();
	      square = new Square();
	   }

	   public void drawCircle(){
	      circle.draw();
	   }
	   public void drawRectangle(){
	      rectangle.draw();
	   }
	   public void drawSquare(){
	      square.draw();
	   }
	}