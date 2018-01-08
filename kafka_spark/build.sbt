name := "kafka_spark"

version := "1.0"

scalaVersion := "2.11.8"

retrieveManaged := true

libraryDependencies += "org.apache.spark" % "spark-core_2.11"% "2.2.0"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.2.0"
libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.2.0"
