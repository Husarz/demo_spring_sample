package co.aisystem.shell;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import io.vavr.control.Try;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class RabbitMqTest {
    private final static String QUEUE_NAME = "hello";
    private final static String HOST = "localhost";
    private final static String PASS = "rabbitmq";
    private final static String USER = "rabbitmq";

    ConnectionFactory factory;
    Channel channel;
    Connection connection;

    @BeforeEach
    public void createCon() {
        createConn();
    }

    @Test
    public void sendTest() throws IOException {

        //given
        val message = "Hello again World in RabbitMq";

        //when
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

    }

    @Test
    public void receiveTest() {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }

    @AfterEach
    public void close() {
        closeChannels();
    }

    private void createConn() {
        factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USER);
        factory.setPassword(PASS);
        final AMQP.Queue.DeclareOk declareOk = Try.of(this::newCon)
                .mapTry(this::getCreateChannel)
                .mapTry(channel -> channel.queueDeclare(QUEUE_NAME, false, false, false, null))
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);
        System.out.println(" [x] declareOk '" + declareOk + "'");

    }

    private Connection newCon() throws IOException, TimeoutException {
        connection = factory.newConnection();
        return connection;
    }

    private Channel getCreateChannel(Connection conn) throws IOException {
        channel = conn.createChannel();
        return channel;
    }

    private void closeChannels() {
        Try.run(() -> {
            channel.close();
            connection.close();
        });
    }
}
