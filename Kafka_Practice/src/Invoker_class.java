import java.util.concurrent.ExecutionException;

public class Invoker_class {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Invoking Producer & Consumer for Spark");
		
		//Producer invoked
		Producer.RunProducer();
		
		//Thread sleep
		Thread.sleep(10000000);
		
		//Consumer invoked
		//Consumer.RunConsumer();
		
		
	}

}
