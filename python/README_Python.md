1. **Create a Kafka Service in Aiven:**
 - Log in to your Aiven account.
 - Go to the dashboard or services section.
 - Click on "Create a new service."
 - Choose Kafka from the list of available services.
 - Configure the Kafka service according to your requirements, such as the cloud provider, region, plan, etc.
 - Review the configuration and confirm the creation of the Kafka service.
 - Once the service is provisioned, you'll receive connection information such as the Kafka broker URL, username, password, and other necessary details.
2. Produce JSON Data to a Kafka Topic
    - Use demo.py as the example code snippet in Python using the confluent_kafka library to produce JSON data to a Kafka topic.
    - Replace `<KAFKA_BROKER_URL>`, `<KAFKA_USERNAME>`, `<KAFKA_PASSWORD>`, and `<YOUR_TOPIC_NAME>` with the respective values provided by Aiven for your Kafka service.
3. Run the Code: Execute the Python script to produce JSON data to the Kafka topic specified.
