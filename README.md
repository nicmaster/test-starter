# Starter

How to use:

Add the dependency to your project's pom


		<dependency>
			<groupId>com.nicmaster.troll</groupId>
            	<artifactId>test.starter</artifactId>
            	<version>0.0.1-SNAPSHOT</version>
		</dependency>

Add config for where MQ is under

spring:
  cloud:
    stream:
      jms.ibmmq:
        host: localhost
        port: 1416
        queueManager: DEV
        channel: testDEV.SVRCONN
        transportType: 1
        binder:
          default-destination-type: queue
    bindings:
    output:
      destination: TEST.SOURCE
      group: default
    database:
      destination: MESSAGE.DATABASE

You can start sending Messages using

  @Autowired
       private MessageService messageService;

         final Message message =  new Message()

         // Map your data to conform to the Message Object.

       messageService.submitMesssage(message);
