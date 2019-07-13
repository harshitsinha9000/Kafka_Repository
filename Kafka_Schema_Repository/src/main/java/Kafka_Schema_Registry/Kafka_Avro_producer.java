package Kafka_Schema_Registry;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class Kafka_Avro_producer {
	
	public static void main(String[] args) {
		Properties properties=new Properties(); 
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
		properties.setProperty("acks", "1");
		properties.setProperty("retries", "10");
		
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
		properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
		
		/*		
		KafkaProducer<String,Customer> kafkaProducer = new KafkaProducer<String,Customer>(properties); 
		String topic = "customer-avro";


		Customer customer = ??? ;
		
		ProducerRecord<String,Customer> producerRecord = new ProducerRecord<String,Customer>(topic,customer);  
		
		kafkaProducer.
		*/
		
	}
	

	

}
