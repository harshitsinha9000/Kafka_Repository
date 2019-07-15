import java.util.Arrays;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import org.slf4j.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.consumer.ConsumerRecords;

class MyCallBack implements Callback
{

	@Override
	public void onCompletion(RecordMetadata arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Producer {

	public static void RunProducer() throws InterruptedException, ExecutionException {
		
		Logger logger=LoggerFactory.getLogger(Producer.class);	
		
		Properties props=new Properties();
		props.setProperty("bootstrap.servers","localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//		props.setProperty("acks", "all");
		props.setProperty("retries", "2");
		
		KafkaProducer<String,String> producer=new KafkaProducer<String,String>(props); 
		//Read from java file
		
		try {
		for(int i=0;i<10;i++)
			producer.send(new ProducerRecord("topic1",Integer.toString(i),"test message - "+i));
			//producer.send(new ProducerRecord());
		}
		catch(Exception e)
		{
			//logger.
			e.printStackTrace();
		}
		finally
		{
			producer.close();
		}
		
}
}
