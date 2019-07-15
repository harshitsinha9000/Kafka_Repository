package KafkaUtil
import org.apache.spark.streaming.kafka010._
//import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.dstream._
import org.apache.spark.streaming._
import org.apache.spark._

object SparkStream {
  def main(args:Array[String])
  {
    val conf=new SparkConf().setMaster("local[2]").setAppName("KafkaReciever")
    val ssc=new StreamingContext(conf,Seconds(10))
    //val kafkaStream = KafkaUtils.createStream(ssc,"localhost:2181","spark-streaming-consumer-group",Map("acadgild-topic" -> 5))
    val kafkaDirectStream = KafkaUtils.createDirectStream(jssc, locationStrategy, consumerStrategy, perPartitionConfig)
    val words=kafkaStream.flatMap(x=> x._2.split(" "))
    val wordcounts=words.map(x=>(x,1)).reduceByKey(_+_)
    kafkaStream.print()
    wordcounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}