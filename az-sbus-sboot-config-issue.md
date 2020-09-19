# Issues while trying to connect Azure Service Bus with Spring Cloud Config Server

## Steps done

* Created a Service Bus in Azure
* Then created a topic called `springcloudbus` & subscriber called `springcloudbus`
* Tried using the Azure Service Bus in Spring Cloud Config Server app

While starting the Config Server application, getting the following exception

```
org.springframework.cloud.stream.binder.BinderException: Exception thrown while starting consumer: 
        at org.springframework.cloud.stream.binder.AbstractMessageChannelBinder.doBindConsumer(AbstractMessageChannelBinder.java:461) ~[spring-cloud-stream-3.0.4.RELEASE.jar:3.0.4.RELEASE]
        at org.springframework.cloud.stream.binder.AbstractMessageChannelBinder.doBindConsumer(AbstractMessageChannelBinder.java:90) ~[spring-cloud-stream-3.0.4.RELEASE.jar:3.0.4.RELEASE]
        at org.springframework.cloud.stream.binder.AbstractBinder.bindConsumer(AbstractBinder.java:143) ~[spring-cloud-stream-3.0.4.RELEASE.jar:3.0.4.RELEASE]
        at org.springframework.cloud.stream.binding.BindingService.lambda$rescheduleConsumerBinding$0(BindingService.java:194) ~[spring-cloud-stream-3.0.4.RELEASE.jar:3.0.4.RELEASE]
        at org.springframework.scheduling.support.DelegatingErrorHandlingRunnable.run(DelegatingErrorHandlingRunnable.java:54) ~[spring-context-5.2.6.RELEASE.jar:5.2.6.RELEASE]
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515) ~[na:na]
        at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264) ~[na:na]
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:304) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128) ~[na:na]
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628) ~[na:na]
        at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: com.microsoft.azure.spring.integration.servicebus.ServiceBusRuntimeException: Failed to register topic message handler; nested exception is com.microsoft.azure.servicebus.primitives.MessagingEntityNotFoundException: The messaging entity 'vicky-sbus:Topic:springcloudbus|anonymous.6858c609-a438-4787-9746-0fa508b1340f' could not be found. To know more visit https://aka.ms/sbResourceMgrExceptions.  TrackingId:ac19b512-c5e4-48bc-9d66-9a985add4225_B13, SystemTracker:vicky-sbus:Topic:springcloudbus|anonymous.6858c609-a438-4787-9746-0fa508b1340f, Timestamp:2020-09-18T10:51:07 TrackingId:bdd7b2f8e7dc45daa0794f6a3d15e8b4_G5, SystemTracker:gateway7, Timestamp:2020-09-18T10:51:07, errorContext[NS: vicky-sbus.servicebus.windows.net, PATH: springcloudbus/subscriptions/anonymous.6858c609-a438-4787-9746-0fa508b1340f, REFERENCE_ID: Receiver_6bd5e8_bdd7b2f8e7dc45daa0794f6a3d15e8b4_G5, PREFETCH_Q_LEN: 0]
        at com.microsoft.azure.spring.integration.servicebus.topic.ServiceBusTopicTemplate.internalSubscribe(ServiceBusTopicTemplate.java:97) ~[spring-integration-servicebus-1.2.8.jar:na]
        at com.microsoft.azure.spring.integration.servicebus.topic.ServiceBusTopicTemplate.subscribe(ServiceBusTopicTemplate.java:62) ~[spring-integration-servicebus-1.2.8.jar:na]
        at com.microsoft.azure.spring.integration.core.api.SubscribeByGroupOperation.subscribe(SubscribeByGroupOperation.java:30) ~[spring-integration-azure-core-1.2.8.jar:na]
        at com.microsoft.azure.spring.integration.core.AbstractInboundChannelAdapter.doStart(AbstractInboundChannelAdapter.java:55) ~[spring-integration-azure-core-1.2.8.jar:na]
        at org.springframework.integration.endpoint.AbstractEndpoint.start(AbstractEndpoint.java:156) ~[spring-integration-core-5.2.6.RELEASE.jar:5.2.6.RELEASE]
        at org.springframework.cloud.stream.binder.AbstractMessageChannelBinder.doBindConsumer(AbstractMessageChannelBinder.java:414) ~[spring-cloud-stream-3.0.4.RELEASE.jar:3.0.4.RELEASE]
        ... 10 common frames omitted
Caused by: com.microsoft.azure.servicebus.primitives.MessagingEntityNotFoundException: The messaging entity 'vicky-sbus:Topic:springcloudbus|anonymous.6858c609-a438-4787-9746-0fa508b1340f' could not be found. To know more visit https://aka.ms/sbResourceMgrExceptions.  TrackingId:ac19b512-c5e4-48bc-9d66-9a985add4225_B13, SystemTracker:vicky-sbus:Topic:springcloudbus|anonymous.6858c609-a438-4787-9746-0fa508b1340f, Timestamp:2020-09-18T10:51:07 TrackingId:bdd7b2f8e7dc45daa0794f6a3d15e8b4_G5, SystemTracker:gateway7, Timestamp:2020-09-18T10:51:07, errorContext[NS: vicky-sbus.servicebus.windows.net, PATH: springcloudbus/subscriptions/anonymous.6858c609-a438-4787-9746-0fa508b1340f, REFERENCE_ID: Receiver_6bd5e8_bdd7b2f8e7dc45daa0794f6a3d15e8b4_G5, PREFETCH_Q_LEN: 0]
        at com.microsoft.azure.servicebus.primitives.ExceptionUtil.toException(ExceptionUtil.java:29) ~[azure-servicebus-3.4.0.jar:na]
        at com.microsoft.azure.servicebus.primitives.CoreMessageReceiver.onClose(CoreMessageReceiver.java:826) ~[azure-servicebus-3.4.0.jar:na]
        at com.microsoft.azure.servicebus.amqp.BaseLinkHandler.processOnClose(BaseLinkHandler.java:68) ~[azure-servicebus-3.4.0.jar:na]
        at com.microsoft.azure.servicebus.amqp.BaseLinkHandler.onLinkRemoteClose(BaseLinkHandler.java:43) ~[azure-servicebus-3.4.0.jar:na]
        at org.apache.qpid.proton.engine.BaseHandler.handle(BaseHandler.java:176) ~[proton-j-0.33.4.jar:na]
        at org.apache.qpid.proton.engine.impl.EventImpl.dispatch(EventImpl.java:108) ~[proton-j-0.33.4.jar:na]
        at org.apache.qpid.proton.reactor.impl.ReactorImpl.dispatch(ReactorImpl.java:324) ~[proton-j-0.33.4.jar:na]
        at org.apache.qpid.proton.reactor.impl.ReactorImpl.process(ReactorImpl.java:291) ~[proton-j-0.33.4.jar:na]
        at com.microsoft.azure.servicebus.primitives.MessagingFactory$RunReactor.run(MessagingFactory.java:556) ~[azure-servicebus-3.4.0.jar:na]
        ... 1 common frames omitted
```

## Source Code

**pom.xml**

```xml
<properties>
		<java.version>1.8</java.version>
		<spring-cloud.version>Hoxton.SR4</spring-cloud.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-monitor</artifactId>
		</dependency>
		<dependency>
			<groupId>com.microsoft.azure</groupId>
			<artifactId>spring-cloud-azure-servicebus-topic-stream-binder</artifactId>
			<version>1.2.8</version>
		</dependency>
    
    <!--		<dependency>-->
		<!--			<groupId>org.springframework.cloud</groupId>-->
		<!--			<artifactId>spring-cloud-starter-stream-rabbit</artifactId>-->
		<!--		</dependency>-->
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

**Application class**

```java
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
```

**application.properties**

```properties
server.port=8888
spring.cloud.config.server.git.uri=https://github.com/iamvickyav/SpringBoot-Cloud-Config-Server-Client.git
spring.cloud.config.server.git.search-paths=config-values
spring.cloud.config.server.git.clone-on-start=true

#spring.rabbitmq.host=localhost
#spring.rabbitmq.port=5672
#spring.rabbitmq.username=guest
#spring.rabbitmq.password=guest

spring.cloud.azure.servicebus.connection-string=<Connection-String-For-Service-Bus-Topic>
spring.cloud.stream.bindings.input.destination=springcloudbus
spring.cloud.stream.bindings.input.group=springcloudbus
spring.cloud.stream.bindings.output.destination=springcloudbus
spring.cloud.stream.servicebus.topic.bindings.input.consumer.checkpoint-mode=MANUAL

spring.cloud.stream.bindings.springCloudBusInput.destination=springcloudbus
spring.cloud.stream.bindings.springCloudBusOutput.destination=springcloudbus
```

(Same code is working with **RabbitMQ**)
