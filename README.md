# Odin Bison Starter

How to use:

Add the dependency to your project's pom


		<dependency>
			<groupId>b.pi.bison</groupId>
            <artifactId>bison.odin.starter</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>

Add config for where MQ is under

spring:
  cloud:
    stream:
      jms.ibmmq:
        host: 22.144.141.127
        port: 1416
        queueManager: MQBSDEV1
        channel: BISONDEV.SVRCONN
        transportType: 1
        binder:
          default-destination-type: queue

    bindings:
    output:
      destination: ODIN.MESSAGE.SOURCE
      group: default
    database:
      destination: ODIN.DATABASE

You can start sending Odin Messages using

  @Autowired
       private OdinMessageService odinMessageService;

         final OdinMessage odinMessage =  new OdinMessage()

         // Map your data to conform to the Odin Message Object.

       odinMessageService.submitOdinMesssage(odinMessage);

# test-starter
