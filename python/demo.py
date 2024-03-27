from confluent_kafka import Producer
import json

# Aiven Kafka connection details
bootstrap_servers = '<KAFKA_BROKER_URL>'
username = '<KAFKA_USERNAME>'
password = '<KAFKA_PASSWORD>'
topic = '<YOUR_TOPIC_NAME>'

# Kafka producer configuration
conf = {
    'bootstrap.servers': bootstrap_servers,
    'security.protocol': 'SSL',  # Depends on your Aiven configuration
    'ssl.key.location': '/path/to/client.key',
    'ssl.certificate.location': '/path/to/client.crt',
    'ssl.ca.location': '/path/to/ca.pem',
    'sasl.mechanism': 'PLAIN',
    'sasl.username': username,
    'sasl.password': password
}

producer = Producer(conf)

# Function to produce JSON data to Kafka topic
def produce_json_data():
    data = {'key': 'value', 'key2': 'value2'}  # Your JSON data
    json_data = json.dumps(data).encode('utf-8')  # Convert to JSON bytes
    producer.produce(topic, value=json_data)  # Produce to Kafka topic
    producer.flush()  # Flush producer buffer

if __name__ == '__main__':
    produce_json_data()
