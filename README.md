# rabbitmq-in-java

### Docker

#### Run
By default, RabbitMQ will listen on port **5672** on all available interfaces
```
docker run -d --hostname my-rabbit --name rabbit-app -p 5672:5672 rabbitmq:3
```

#### Management Plugin
```
docker run -d --hostname my-rabbit --name rabbit-management -p 15672:15672 -e RABBITMQ_DEFAULT_VHOST=my-rabbit rabbitmq:3-management
```
Acces on http://localhost:15672 with username `guest` and password `guest`

#### To exterminate all RabbitMQ docker containers :)
```
docker kill rabbit-app && docker rm rabbit-app
docker kill rabbit-management && docker rm rabbit-management
```

#### Logs
See logs (`--follow` to tail):
```
docker logs [--follow] rabbit-app
```

### References
- https://github.com/rabbitmq/rabbitmq-tutorials/tree/master/java
- https://www.rabbitmq.com/tutorials/tutorial-one-java.html
