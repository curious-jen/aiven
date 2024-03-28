import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.util.Properties;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KafkaProducerExample {

    public static void main(String[] args) {
        // Kafka producer configuration
        String TOPIC_NAME = "name_topic";
        Properties props = new Properties();
        props.put("bootstrap.servers", KAFKA_BROKER_URL);
        props.put("security.protocol", "SSL");  // Depends on your Aiven configuration
        props.put("ssl.keystore.location", "/path/to/keystore.p12");
        props.put("ssl.keystore.password", "keystore_password");
        props.put("ssl.key.password", "key_password");
        props.put("ssl.truststore.location", "/path/to/truststore.jks");
        props.put("ssl.truststore.password", "truststore_password");
        props.put("ssl.endpoint.identification.algorithm", "");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + KAFKA_USERNAME + "\" password=\"" + KAFKA_PASSWORD + "\";");
        props.put("key.serializer", StringSerializer.class.getName()); // Use StringSerializer for key
        props.put("value.serializer", StringSerializer.class.getName()); // Use StringSerializer for value

        Producer<String, String> producer = new KafkaProducer<>(props);

        // Generate multiple JSON payloads
        for (int i = 0; i < 5; i++) {
            String key = UUID.randomUUID().toString(); // Generate random UUID as key
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String payload = "{\"sensor_id\": \"sensor" + i + "\", \"value\": " + (100 + i) + ", \"timestamp\": \"" + timestamp + "\", \"location\": \"Room A\", \"status\": \"active\"}";

            // Produce JSON payload to Kafka topic
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, payload);
            producer.send(record);
        }

        producer.flush();
        producer.close();
    }
}
