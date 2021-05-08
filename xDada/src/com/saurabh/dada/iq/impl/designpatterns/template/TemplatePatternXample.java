package com.saurabh.dada.iq.impl.designpatterns.template;

public class TemplatePatternXample {
	
	public static void main(String[] args) {

		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
		
	}

}
