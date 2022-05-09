# Java-Microservice
# Author : Deepesh Kumar Pandey
# IG : @beer_to_code
# Consumer Microservice is Build in Java 8

# "Consumer Microservice API",

# An Agent through Insureity App can interact with Consumer Service to create new consumer / update consumer details. Consumer is the customer here who wishes to subscribe to a Business Property Insurance with the Insurance Company. In this project we are restricting to Property Insurance that means the land/building in which the business is operated will be covered. \r\n" + 
# "The Consumer Microservice has to interact with Policy Microservice to create a policy and as well as to view the policy status \r\n" + 
# "Post Authorization, the Consumer Microservice will perform the following functionalities: \r\n" + 
#    @  Create Consumer Business \r\n" + 
#    @  Create Business Property \r\n" + 
#    @  View Consumer Business \r\n" + 
#    @  View Business Property \r\n" + 
#    @  Update Consumer Business \r\n" + 
#    @  Update Business Property  ",


#   Version : "1.0",
#   Copyright : "©Copyright Application",


##########################################################################################################
                ######    EDIT PROPERTIES FILE ACCORDING TO YOUR REQUIREMENT   #######
----------------------------------------------------------------------------------------------------------

#name of service 
spring.application.name=consumer-service 

#Server Port
server.port=9090

#default is / {change the value to use custom context url
management.endpoints.web.base-path=/manage
server.servlet.context-path=/consumer-api


#MySql Configuration
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/<Database Name>
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto= update 
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.show-sql=true
  
#H2 Db Config
#spring.datasource.url=jdbc:h2:mem:pasdb
#spring.datasource.driverClassName=org.h2.Driver
#spring.datasource.username=Username
#spring.datasource.password=password
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.jpa.hibernate.ddl-auto= update
# Enabling H2 Console
#spring.h2.console.enabled=true
# Whether to enable remote access.
#spring.h2.console.settings.web-allow-others=true


#Logger Config
logging.level.org.springframework=info
logging.level.com.cognizant=debug

  
#JWT Spring Web Security Configuration
jwt.secretKey=a!m@12itha!m@12itha!m@12itha!m@12itha!m@12itha!m@12itha!m@12itha!m@12ith
jwt.tokenPrefix=Bearer
jwt.tokenExpirationDate=15
jwt.tokenHeader=Authorization
jwt.claimsName=authorities
jwt.authority=authority


closeMethod="close"/>


