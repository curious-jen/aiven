import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Properties;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KafkaProducerExample {

    private static final String KAFKA_BROKER_URL = "<KAFKA_BROKER_URL>";
    private static final String KAFKA_USERNAME = "<KAFKA_USERNAME>";
    private static final String KAFKA_PASSWORD = "<KAFKA_PASSWORD>";
    private static final String TOPIC_NAME = "<YOUR_TOPIC_NAME>";

    public static void main(String[] args) {
        // Kafka producer configuration
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
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", ByteArraySerializer.class.getName());

        Producer<String, byte[]> producer = new KafkaProducer<>(props);

        // Create JSON data
        ObjectMapper objectMapper = new ObjectMapper();
        String key = UUID.randomUUID().toString(); // Generate random UUID as key
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String jsonData = "{\"sensor_id\": \"sensor1\", \"value\": 123.45, \"timestamp\": \"" + timestamp + "\"}";

        // Produce JSON data to Kafka topic
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(TOPIC_NAME, key, jsonData.getBytes());
        producer.send(record);

        producer.flush();
        producer.close();
    }
}

