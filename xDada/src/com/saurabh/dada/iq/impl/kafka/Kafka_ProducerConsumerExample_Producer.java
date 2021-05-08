package com.saurabh.dada.iq.impl.kafka;

public class Kafka_ProducerConsumerExample_Producer {

	public static void main(String[] args) throws Exception {
		
		try {
			Kafka_JavaProducer kafkaJavaProducer = new Kafka_JavaProducer();
			kafkaJavaProducer.startProducer();
			
		}
		catch(Throwable t) {
			t.printStackTrace();
		}

	}

}
