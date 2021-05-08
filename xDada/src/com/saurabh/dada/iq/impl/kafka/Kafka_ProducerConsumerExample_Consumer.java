package com.saurabh.dada.iq.impl.kafka;

public class Kafka_ProducerConsumerExample_Consumer {

	public static void main(String[] args) throws Exception {
		
		try {	
			Kafka_JavaConsumer kafkaJavaConsumer = new Kafka_JavaConsumer();
			kafkaJavaConsumer.startConsumer();
		}
		catch(Throwable t) {
			t.printStackTrace();
		}

	}

}
