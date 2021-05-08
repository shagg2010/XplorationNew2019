package com.saurabh.dada.iq.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class Java8_DateTime {

	public static void main(String[] args) {
		
		Instant instant = Instant.now();
		System.out.println(instant);
		Instant instant1 = instant.plus(Duration.ofMillis(5000));
		Instant instant2 = instant.minus(Duration.ofMillis(5000));
		Instant instant3 = instant.minusSeconds(10);
		
		
		Duration duration = Duration.ofMillis(5000);
		duration = Duration.ofSeconds(60);
		duration = Duration.ofMinutes(10);
		
		Period period = Period.ofDays(6);
		period = Period.ofMonths(6);
		period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));
		System.out.println(period);

	}

}
