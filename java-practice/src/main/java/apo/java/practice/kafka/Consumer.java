package apo.java.practice.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Consumer {
    private Properties properties = new Properties();

    private org.apache.kafka.clients.consumer.Consumer<String, String> consumer;

    public Consumer(String ip, int port) {
        properties.put("bootstrap.servers", ip.concat(":").concat(String.valueOf(port)));
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        consumer = new KafkaConsumer<>(properties);
    }

    public List<String> consume(String event, String key) {
        consumer.subscribe(List.of(event));
        var message = consumer.poll(Duration.ofMillis(1000));
        var answer = new ArrayList<String>();
        message.iterator().forEachRemaining(e -> answer.add(e.key() + " " + e.value()));
        consumer.close();
        return answer;
    }

}
