# Aiven Quickstart Guide with Java 

This repo houses a getting started guide to walk through a mock setup of Aiven for Apache Kafka®, Aiven for Flink® and well as integrating Aiven observability components.
Our completed work will include the following components:
 
 - A producer (in Java) sending mock IOT data to Kafka.
 - A Flink service filtering the incoming messages and sending the filtered data to Kafka
 - A Kafka service integrated with the Aiven Observability stack. 

# Setup and Configuration
-  **Sign Up:** Visit the Aiven website and sign up for an account. You'll need to provide some basic information like your email address, company name, etc. https://console.aiven.io/signup
- **Verify Email:** After signing up, you might need to verify your email address by clicking on a link sent to your email inbox.
- **Login:** Once your email is verified, you will be able to login to your Aiven account. Aiven console for configuring the services in the following sections.


## Aiven for Apache Kafka®
https://aiven.io/docs/products/kafka

### 1. Setup your First Kafka Service  
Select a cloud provider, the region where you want to deploy the service, and the plan that determines the amount of resources available for your cluster. We are going with the *Startup-2* (2 CPU, 2 GB RAM, 90 GB storage, no backups) 3-node high availability set. This will be plenty of resources for testing. 

### 2. Access Credentials
After the services are provisioned (this will only take a few minutes), you'll receive access credentials (such as connection URLs, usernames, passwords, API tokens) for accessing your services. For this exercise, we will be using Java and therefore we will need to configure the Java connection method. You can reference this doc for details:https://aiven.io/docs/products/kafka/howto/connect-with-java. 
*note The SSL method was used for the JAVA code reference.*
![image](https://github.com/curious-jen/aiven/assets/165078304/eb8d07d3-36f5-4dce-9c9b-55cdd26df082)

### 3. Configure the first topic
![image](https://github.com/curious-jen/aiven/assets/165078304/d91bc799-6cfa-4b19-af7e-f5f557ea1e92)

The instruction set is here. https://aiven.io/docs/products/kafka/howto/create-topic

### 4. Test Consume and Produce messages

Please replace the truststore and keystore password with the values that you used in the previous step 2.
Details on the variables can be found here: https://aiven.io/docs/products/kafka/howto/schema-registry#kafka_schema_registry_variables

![image](https://github.com/curious-jen/aiven/assets/165078304/d6e1ff7b-7b91-49a1-8d4e-04718f39d823)

### 5. Endpoint integrations
We will not be setting this up at this stage. So you can select **Finish Setup** to complete the setup. 

### Kafka Exercise
Here we will create a Kafka service in Aiven and write a piece of code that produces valid JSON data to a topic in that service. 
 - The key will be a valid JSON string containing a random id, e.g. UUID, and the message payload will be a valid JSON object. 
 - The payload should be a mock "event" of an IOT device.
 - The event will include a timestamp represented by a string with the date in ISO 8601 format. 
 - The producer's data will be readable from the Aiven web console from the Kafka service view > Topics => Topic => Fetch Messages.

=>[Here is the reference to the code to produce the mock IOT events](https://github.com/curious-jen/aiven/blob/main/java-tqs/main/java/io/aiven/demo/kafka/ProducerDemo.java)

## Aiven for Apache Flink®
https://aiven.io/docs/products/flink/get-started
  
### 1. Create a New Flink Service 
In your existing project, Select **Create Service** =>Create Apache Flink® service, Select the Business-4 plan, update the Name if desired => then select **Create service**

### 2. Create data pipeline (integration)
Select Create a data pipeline, then select your Kafka service, then **Integrate**
![image](https://github.com/curious-jen/aiven/assets/165078304/34c2d883-d14b-4f6c-88a8-091820a68f34)
![image](https://github.com/curious-jen/aiven/assets/165078304/4215decc-97b7-4642-9dd8-dbdee996bf50)

### 3. Create a Flink SQL Application
https://aiven.io/docs/products/flink/howto/create-sql-application
 - https://aiven.io/docs/products/flink/howto/connect-kafka#create-apache-flink-table-with-aiven-console

   
### Flink Exercise
Now that we have the data flowing into the Kafka topic, we will integrate your Kafka service with Aiven for Flink to filter the data into two new topics. Our goal here is to create two Flink jobs to split the data to show the power of Flink filtering. 
 - We will use an attribute within the JSON payload (e.g. odd/even date seconds, a number modulo 2, etc.) to bifurcate incoming data into two topics.


# Monitor and Manage
Monitor the performance and health of your services using Aiven. 

## Aiven for Grafana®


## References
- **Aiven Blog** https://aiven.io/blog
- **Aiven Docs Center** https://aiven.io/docs
- **Aiven for Apache Flink®** https://aiven.io/flink
- **Aiven for Apache Kafka®** https://aiven.io/kafka
- **Aiven for Grafana®** https://aiven.io/grafana
- **Aiven Github** https://github.com/aiven
- **Aiven Ideas (Product Request) Portal** https://ideas.aiven.io/ 

