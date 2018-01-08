# Spark Examples

## Kafka example

### Compile

```
sbt package
```

### Collect dependencies

```
prepend () {
  while read line; do echo "$1$line"; done
}

remove-spark () {
  while read line; do
    if ! echo "$line" | grep -q "org.apache.spark"; then
      echo "$line"
    elif echo "$line" | grep -q "spark-streaming-kafka-0-10_2.11-2.2.0.jar"; then
      echo "$line"
    fi
  done
}

jars=$(find `pwd`/lib_managed/ -type f \
    | remove-spark \
    | prepend "local://" \
    | paste -sd ,
)
```

### Run

```
/home/david/spark/spark-2.2.1-bin-hadoop2.7/bin/spark-submit --class "DirectKafkaWordCount" --master local[*] --jars "$jars" ./target/scala-2.11/kafka_spark_2.11-1.0.jar <kafka_ulr> <kafka_topic_name>
```
