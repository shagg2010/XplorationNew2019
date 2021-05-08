package com.saurabh.dada.iq.impl;

public class FootballGame {

	public static void main(String[] args) {
		Ball gameBall = new Ball();
		Runnable playerOne = new Player("Pasha", gameBall);
		Runnable playerTwo = new Player("Maxi", gameBall);

		new Thread(playerOne).start();
		new Thread(playerTwo).start();
		
	}

}

class Player implements Runnable {

	private final String name;
	private final Ball ball;

	public Player(String aName, Ball aBall) {
		name = aName;
		ball = aBall;
	}

	@Override
	public void run() {
		while (true) {
			ball.kick(name);
			ball.getLog();
		}
	}

}

class Ball {

	private String log;

	public Ball() {
		log = "";
	}

	// Removing the synchronized keyword will cause a race condition.
	public  void kick(String aPlayerName) {
		log += aPlayerName + " ";
	}

	public String getLog() {
		return log;
	}

}
