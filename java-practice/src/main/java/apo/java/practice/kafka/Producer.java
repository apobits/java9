package apo.java.practice.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {
    private Properties properties = new Properties();

    private org.apache.kafka.clients.producer.Producer<String, String> producer;

    public Producer(String ip, int port) {
        properties.put("bootstrap.servers", ip.concat(":").concat(String.valueOf(port)));
        properties.put("linger.ms", 1);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }

    public void produce(String topic, String keyEvent, String valueEvent) throws ExecutionException, InterruptedException {
        producer.send(new ProducerRecord<>(topic, keyEvent, valueEvent), (m, e) -> {
            System.out.println("message at offset: " + m.offset());
        });
        producer.flush();
    }

    public void close() {
        producer.close();
    }
}
