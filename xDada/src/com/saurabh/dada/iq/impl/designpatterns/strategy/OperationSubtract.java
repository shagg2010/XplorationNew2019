package com.saurabh.dada.iq.impl.designpatterns.strategy;

public class OperationSubtract implements Strategy{
	   @Override
	   public int doOperation(int num1, int num2) {
	      return num1 - num2;
	   }
	}
