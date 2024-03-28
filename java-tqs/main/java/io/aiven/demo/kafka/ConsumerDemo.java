package your.project;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public final class ConsumerDemo {
    public static void main(String[] args) {
        String TOPIC_NAME = "default_topic";
        String TRUSTSTORE_PASSWORD = "TRUSTSTORE_PASSWORD";
        String KEYSTORE_PASSWORD = "KEYSTORE_PASSWORD";
        String KEY_PASSWORD = "KEY_PASSWORD";

        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "kafka-test-aiven-tqs.a.aivencloud.com:17033");
        props.setProperty("security.protocol", "SSL");
        props.setProperty("ssl.truststore.location", "client.truststore.jks");
        props.setProperty("ssl.truststore.password", TRUSTSTORE_PASSWORD);
        props.setProperty("ssl.keystore.type", "PKCS12");
        props.setProperty("ssl.keystore.location", "client.keystore.p12");
        props.setProperty("ssl.keystore.password", KEYSTORE_PASSWORD);
        props.setProperty("ssl.key.password", KEY_PASSWORD);
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", StringDeserializer.class.getName());
        props.setProperty("group.id", "groupid");

        // create a consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList(TOPIC_NAME));
        while (true) {
            ConsumerRecords<String, String> messages = consumer.poll(Duration.ofMillis(100));
            messages.forEach(message -> {
              System.out.println("Got message using SSL: " + message.value());
            });
        }
    }
}
