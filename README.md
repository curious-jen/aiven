# Aiven Quickstart Guide

This repo houses a getting started guide to walk through a mock setup up of: Aiven for Apache Kafka®, Aiven for Flink® and well as integrating Aiven Obseribility components (Influx DB, OpenSearch®, and Grafana®).
Our completed work will include the following components:
 - A Kafka service integrated with the Aiven Observability stack. 
 - A producer (in Java) sending data to Kafka.
 - A Flink service filtering the incoming messages and sending the filtered data to Kafka


## Setup and Configuration
1. **Sign Up:** Visit the Aiven website and sign up for an account. You'll need to provide some basic information like your email address, company name, etc. https://console.aiven.io/signup 
2. **Verify Email:** After signing up, you might need to verify your email address by clicking on a link sent to your email inbox.<img 
3. **Login:** Once your email is verified, you will be able to login to your Aiven account. Aiven console for configuring the services in the following sections.
4. **Setup your First Service**  To create a Kafka Service, select a cloud provider, the region where you want to deploy the service, and the plan that determines the amount of resources available for your cluster. We are going with the Business-4.
5.  **Access Credentials** After the services are provisioned, you'll receive access credentials (such as connection URLs, usernames, passwords, API tokens) for accessing your services. For this exercise, we will be using Java and therefore will need to configure the Java connection method. You can reference this doc for details:https://aiven.io/docs/products/kafka/howto/connect-with-java.
6. **Configure the first topic:** https://aiven.io/docs/products/kafka/howto/create-topic
7. **Integration:** Integrate the provisioned services into your application or infrastructure. This might involve updating connection strings, configurations, etc., in your application.
8. **Monitor and Manage:** Monitor the performance and health of your services using Aiven's 



## Aiven for Apache Kafka®
Aiven for Apache Kafka® is a fully managed distributed data streaming platform, deployable in the cloud of your choice. Apache Kafka is an open-source data streaming platform, ideal for event-driven applications, near-real-time data transfer and pipelines, stream analytics, and many more applications where a lot of data needs to move between applications in a speedy manner.

Kafka stores a potentially large number of records, each containing a small amount of data, usually for a limited period of time. The storage is organized into "topics" and "partitions" so that many data streams can be handled at once, regardless of how much data is flowing into or out of your Aiven for Apache Kafka service.

### Kafka Setup and Config
Here we will create a Kafka service in Aiven and write a piece of code that produces valid JSON data to a topic in that service. 
 - The key will be a valid JSON string containing a random id, e.g. UUID, and the message payload will be a valid JSON object. 
 - The payload should be a mock  "event" of: 
 - The event will include a timestamp represented by a string with the date in ISO 8601 format. 
 - The producer's data will be readable from the Aiven web console from the Kafka service view > Topics => Topic => Fetch Messages (Format: JSON).



## Aiven for Apache Flink®
Now that we have the data flowing into the Kafka topic, we will integrate your Kafka service with Aiven for Flink to filter the data into two new topics. Our goal here is to create two Flink jobs to split the data to show the power of Flink filtering.    
 - We will use an attribute within the JSON payload (e.g. odd/even date seconds, a number modulo 2, etc.) to bifurcate incoming data into two topics.  


## InfluxDB 
## Aiven for OpenSearch®
## Aiven for Grafana®

## Assumptions, Exceptions and Notes. 
To keep this exercise succinct and fairly simplistic, we will be using the UI whenever possible. This mitigates nuances/challenges for those who may not be using Mac. 

## References
- **Aiven Blog** https://aiven.io/blog
- **Aiven Docs Center** https://aiven.io/docs
- **Aiven for Apache Flink®** https://aiven.io/flink
- **Aiven for Apache Kafka®** https://aiven.io/kafka
- **Aiven for OpenSearch®** https://aiven.io/opensearch
- **Aiven Github** https://github.com/aiven
- **Aiven for Grafana®** https://aiven.io/grafana
- **Aiven Ideas (Product Request) Portal** https://ideas.aiven.io/ 

