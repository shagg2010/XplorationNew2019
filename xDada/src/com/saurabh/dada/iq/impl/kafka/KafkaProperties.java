package com.saurabh.dada.iq.impl.kafka;

public class KafkaProperties {
    public static final String TOPIC1 = "kjavatopic";
    public static final String KAFKA_SERVER_URL = "localhost";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC20 = "topic2";
    public static final String TOPIC30 = "topic3";
    public static final String CLIENT_ID = "SimpleJavaConsumerDemoClient";
    //public static final String KAFKA_BROKERS = "localhost:9092";
    
    private KafkaProperties() {}
}
