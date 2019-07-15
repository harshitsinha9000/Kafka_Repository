import java.util.Arrays;
import java.util.Properties;
import java.util.function.Supplier;

import org.apache.kafka.clients.consumer.*;

public class Consumer {
	// TODO Auto-generated method stub
	
	public static void RunConsumer()
	{
	Properties props=new Properties();
	props.setProperty("bootstrap.servers","localhost:9092");
	props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	props.setProperty("heartbeat.interval.ms", "3000");
	props.setProperty("session.timeout.ms","300000");
	props.setProperty("enable.auto.commit","false");
	props.put("group.id", "test-group");
	
	
	KafkaConsumer<String,Supplier> consumer=new KafkaConsumer<String,Supplier>(props);
	consumer.subscribe(Arrays.asList("topic1"));
	
	try
	{
	while(true)
	{
			ConsumerRecords<String,Supplier> records=consumer.poll(10);
			
			records.forEach(record -> {
				System.out.println(record.key());
				System.out.println(record.value());
			});
			
			consumer.commitAsync();
			
			
	}
	}
	catch(Exception e)
	{
		 System.out.println(e.getMessage());
	}finally {
		consumer.close();
    }
}
}