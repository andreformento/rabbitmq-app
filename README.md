# rabbitmq-in-java

### Docker

#### Run
By default, RabbitMQ will listen on port **5672** on all available interfaces
```
docker run -d --hostname my-rabbit --name rabbit-app -p 5672:5672 rabbitmq:3
```

#### Management Plugin
```
docker run -d --hostname my-rabbit --name rabbit-management -p 15672:15672 rabbitmq:3-management
```
Acces on http://localhost:15672

#### Logs
See logs (`--follow` to tail):
```
docker logs [--follow] some-rabbit
```

### References
- https://github.com/rabbitmq/rabbitmq-tutorials/tree/master/java
- https://www.rabbitmq.com/tutorials/tutorial-one-java.html
