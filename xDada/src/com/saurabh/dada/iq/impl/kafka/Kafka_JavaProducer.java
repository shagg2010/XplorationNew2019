package com.saurabh.dada.iq.impl.kafka;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class Kafka_JavaProducer {
	
	private final KafkaProducer<Integer, String> producer;
	private final Boolean isAsync;

	public Kafka_JavaProducer() {
		Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "JavaDemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(props);
        isAsync = true;
	}
	
	public void startProducer() {
		try {
			int messageNo = 1;
	        while (true) {
	            String messageStr = "Message_" + messageNo;
	            long startTime = System.currentTimeMillis();
	            if (isAsync) { // Send asynchronously
	                producer.send(new ProducerRecord<>(KafkaProperties.TOPIC1, messageNo, messageStr), new DemoCallBack(startTime, messageNo, messageStr));
	            } else { // Send synchronously
	                try {
	                    producer.send(new ProducerRecord<>(KafkaProperties.TOPIC1,messageNo,messageStr)).get();
	                    System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            ++messageNo;
	            TimeUnit.SECONDS.sleep(1);
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

class DemoCallBack implements Callback {

    private final long startTime;
    private final int key;
    private final String message;

    public DemoCallBack(long startTime, int key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * A callback method the user can implement to provide asynchronous handling of request completion. This method will
     * be called when the record sent to the server has been acknowledged. When exception is not null in the callback,
     * metadata will contain the special -1 value for all fields except for topicPartition, which will be valid.
     *
     * @param metadata  The metadata for the record that was sent (i.e. the partition and offset). Null if an error
     *                  occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println("message: (" + key + ", " + message + ") sent to partition (" + metadata.partition() +
                    "), " + "offset (" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}
