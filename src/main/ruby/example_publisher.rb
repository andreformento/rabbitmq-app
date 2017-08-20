#example_publisher.rb
require "rubygems"
require "bunny"
require "json"

#Returns a connection instance
conn = Bunny.new(:host => "localhost")
#The connection will be established when start is called
conn.start

#create a channel in the TCP connection
ch = conn.create_channel

#Declare a queue with a given name, examplequeue. In this example is a durable shared queue used.
q  = ch.queue("examplequeue", :durable => true)
# ch.queue is used to declare a queue with a particular name, in this case, the queue is called examplequeue. The queue in this example is marked as durable, meaning that RabbitMQ will never lose our queue.

#BIND THE QUEUE TO AN EXCHANGE
#For messages to be routed to queues, queues need to be bound to exchanges.
x = ch.direct("example.exchange", :durable => true)

#Bind a queue to an exchange
q.bind(x, :routing_key => "process")

#For messages to be routed to queues, queues need to be bound to exchanges.
x = ch.direct("example.exchange", :durable => true)
information_message = "{\"email\": \"example@mail.com\",\"name\": \"name\",\"size\": \"size\"}"

x.publish(information_message,
  :timestamp      => Time.now.to_i,
  :routing_key    => "process"
)

sleep 1.0
conn.close
