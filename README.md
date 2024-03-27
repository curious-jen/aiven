# Aiven Quickstart Guide

This repo houses a getting started guide to walk through a mock setup up of: Aiven for Apache Kafka®, Aiven for Flink® and well as integrating Aiven Obseribility components (Influx DB, OpenSearch®, and Grafana®).
Our completed work will include the following components:
 - A Kafka service integrated with the Aiven Observability stack. 
 - A producer (in Java) sending data to Kafka.
 - A Flink service filtering the incoming messages and sending the filtered data to Kafka


## Setup and Configuration

### Aiven Platform
1. Signup for an Aiven trial account: https://console.aiven.io/signup <img width="650" alt="sign up screen" src="https://github.com/curious-jen/aiven/assets/165078304/83561e45-d464-4713-9e2f-839e60a638bc">

2. Activate (verify) account sign-up if using GitHub/Microsoft/Google <img width="500" alt="email verification" src="https://github.com/curious-jen/aiven/assets/165078304/0330cd88-65ec-44c4-ab89-7fd1561ea66e">

3.

### Aiven for Apache Kafka®
Here we will create a Kafka service in Aiven and write a piece of code that produces valid JSON data to a topic in that service. 
 - The key will be a valid JSON string containing a random id, e.g. UUID, and the message payload will be a valid JSON object. 
 - The payload should be a mock  "event" of: 
 - The event will include a timestamp represented by a string with the date in ISO 8601 format. 
 - The producer's data will be readable from the Aiven web console from the Kafka service view > Topics => Topic => Fetch Messages (Format: JSON). 

### Aiven for Apache Flink®
### InfluxDB 
### Aiven for OpenSearch®
### Aiven for Grafana®


## References
- **Aiven Blog** https://aiven.io/blog
- **Aiven Docs Center** https://aiven.io/docs
- **Aiven for Apache Flink®** https://aiven.io/flink
- **Aiven for Apache Kafka®** https://aiven.io/kafka
- **Aiven for OpenSearch®** https://aiven.io/opensearch
- **Aiven Github** https://github.com/aiven
- **Aiven for Grafana®** https://aiven.io/grafana
- **Aiven Ideas (Product Request) Portal** https://ideas.aiven.io/ 

