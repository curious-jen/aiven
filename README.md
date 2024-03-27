# Aiven Quickstart Guide

This repo houses a getting started guide to walk through a mock setup up of: Aiven for Apache Kafka®, Aiven for Flink® and well as integrating Aiven Obseribility components (Influx DB, OpenSearch®, and Grafana®).
Our completed work will include the following components:
 - A Kafka service integrated with the Aiven Observability stack. 
 - A producer (in Java) sending data to Kafka.
 - A Flink service filtering the incoming messages and sending the filtered data to Kafka


## Aiven Platform
1. Signup for an Aiven trial account. Sign Up: Visit the Aiven website and sign up for an account. You'll need to provide some basic information like your email address, company name, etc. https://console.aiven.io/signup <img width="650" alt="sign up screen" src="https://github.com/curious-jen/aiven/assets/165078304/83561e45-d464-4713-9e2f-839e60a638bc">

2. Activate (verify) account sign-up if using GitHub/Microsoft/Google <img width="500" alt="email verification" src="https://github.com/curious-jen/aiven/assets/165078304/0330cd88-65ec-44c4-ab89-7fd1561ea66e">

3. You will now be able to access Aiven console for configuring the services in the following sections. <img width="650" alt="email verification" src="https://github.com/curious-jen/aiven/assets/165078304/314d152b-a473-4626-8ac8-96aa40a86f81">



## Aiven for Apache Kafka®
Aiven for Apache Kafka® is a fully managed distributed data streaming platform, deployable in the cloud of your choice. Apache Kafka is an open source data streaming platform, ideal for event-driven applications, near-real-time data transfer and pipelines, stream analytics, and many more applications where a lot of data needs to move between applications in a speedy manner.

Kafka stores a potentially large number of records, each contains a small amount of data, usually for a limited period of time. The storage is organised into "topics" and "partitions" so that many data streams can be handled at once, regardless of how much data is flowing into or out of your Aiven for Apache Kafka service.

### Kafka Setup and Config
Here we will create a Kafka service in Aiven and write a piece of code that produces valid JSON data to a topic in that service. 
 - The key will be a valid JSON string containing a random id, e.g. UUID, and the message payload will be a valid JSON object. 
 - The payload should be a mock  "event" of: 
 - The event will include a timestamp represented by a string with the date in ISO 8601 format. 
 - The producer's data will be readable from the Aiven web console from the Kafka service view > Topics => Topic => Fetch Messages (Format: JSON).

1. *Create a new Kafka Service in your cloud provider and region of choice.* To create a Kafka Service, select a cloud provider, the region where you want to deploy the service, and the plan that determines the amount of resources available for your cluster. We are going with the Business-4 as this will not require significant resource. Finally set the service name; in this example, 

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

