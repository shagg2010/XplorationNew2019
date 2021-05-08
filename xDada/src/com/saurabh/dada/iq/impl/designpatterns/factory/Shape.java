package com.saurabh.dada.iq.impl.designpatterns.factory;

public interface Shape {
	public enum ShapeType { RECTANGLE, SQUARE, CIRCLE};
	void draw();
}