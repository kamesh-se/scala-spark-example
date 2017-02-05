/**
  * Created by admin on 4/2/17.
  */
import org.apache.spark.{SparkConf, SparkContext}

object example {

  def main(args: Array[String]) {

   // val sparkConf = new SparkConf().setAppName("Log Query").setMaster("local")
   // val sc = new SparkContext(sparkConf)
   // sc.stop()

    val logFile = "src/main/resources/sample.txt" // Should be some file on your system
    val sc = new SparkContext("local", "Simple App")
    val logData = sc.textFile(logFile, 2).cache()
    val numTHEs = logData.filter(line => line.contains("GitHub")).count()
    println("Lines with the: %s".format(numTHEs))
  }



}
