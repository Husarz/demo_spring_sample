package co.aisystem.shell.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import io.vavr.control.Try;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

@Slf4j
public class RabbitConnection {

    private final String QUEUE_NAME = "hello";
    private final String HOST = "localhost";
    private final String PASS = "rabbitmq";
    private final String USER = "rabbitmq";

    @Getter
    private ConnectionFactory factory;
    @Getter
    private Connection connection;
    @Getter
    private Channel channel;
    @Getter
    Consumer simpleConsumer;
    @Getter
    Consumer workConsumer;

    @Getter
    final Map<Integer, Channel> channells = new HashMap<>();

    @Getter
    @Setter
    boolean autoAck;

    Connection newCon() throws IOException, TimeoutException {
        connection = factory.newConnection();
        return connection;
    }

    Channel getCreateChannel(Connection conn) throws IOException {
        channel = conn.createChannel();
        return channel;
    }

    public Channel createNewChannel(Integer number) throws IOException {
        final Channel channel = connection.createChannel(number);
        channells.put(number, channel);
        return channel;
    }

    public void createConn() {
        factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USER);
        factory.setPassword(PASS);
        final AMQP.Queue.DeclareOk declareOk = Try.of(this::newCon)
                .mapTry(this::getCreateChannel)
                .mapTry(channel -> channel.queueDeclare(QUEUE_NAME, false, false, false, null))
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
        log.debug(" [x] declareOk '{}'", declareOk);
    }

    public void declarSimpleConsumer(java.util.function.Consumer f) throws IOException {
        simpleConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                f.accept(msg);
            }
        };
        log.debug(" [==] consumer declared");
        channel.basicConsume(QUEUE_NAME, true, simpleConsumer);
    }

    private void workerDone(Envelope envelope) throws IOException {
        System.out.println(" [x] Done");
        if (!autoAck)
            channel.basicAck(envelope.getDeliveryTag(), false);
    }

    public void declarWorkerConsumer(java.util.function.Consumer f) throws IOException {
        workConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                Try.run(() -> f.accept(msg))
                        .andFinallyTry(() -> workerDone(envelope))
                        .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
            }
        };
        log.debug(" [==] consumer worker declared");
        channel.basicConsume(QUEUE_NAME, autoAck, workConsumer);
    }

    public void sendMessage(String message) throws IOException {
        log.debug(" [x] Sending '{}'", message);
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
    }

    public void closeChannels() {
        Try.run(() -> {
            channel.close();
            connection.close();
        });
    }

//    public void simpleConsumer(Object message) {
//        System.out.println(" [x] Received '" + message + "'");
//    }
//
//    public void declar() throws IOException {
//        declarSimpleConsumer(this::simpleConsumer);
//    }
}
