# rabbitmq-app

### Build application

##### Java
Requirements
- Java 8
- Gradle
```
gradle buildDocker
docker-compose up
```

Call
```
curl -X POST 'http://localhost:8081/queue?message=my-custom-message'
```

##### Ruby
Before
```
gem install bunny
gem install json
```
To run
```
ruby src/main/ruby/example_consumer.rb
ruby src/main/ruby/example_publisher.rb
```

### Using Docker
```
docker-compose up [-d]
```
Access on http://localhost:15672 with username `guest` and password `guest`

### References
- https://github.com/rabbitmq/rabbitmq-tutorials/tree/master/java
- https://www.rabbitmq.com/tutorials/tutorial-one-java.html
- https://www.cloudamqp.com/blog/2015-05-18-part1-rabbitmq-for-beginners-what-is-rabbitmq.html
- https://spring.io/guides/gs/messaging-rabbitmq
- https://docs.spring.io/spring-amqp/reference/html/_introduction.html
