package idea.mq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageQueue {
    private final Exchange exchange;
    private final Map<String, List<Consumer>> topicConsumers;

    public MessageQueue() {
        this.exchange = new Exchange();
        this.topicConsumers = new HashMap<>();
    }

    public void createTopic(String topicName) {
        exchange.createTopic(topicName);
    }

    public void publish(String exchangeName, String routingKey, Message message) {
        exchange.getTopic(exchangeName).addMessage(routingKey, message);
        notifyConsumers(exchangeName, routingKey, message);
    }

    public void subscribe(String exchangeName, String routingKey, Consumer consumer) {
        List<Consumer> consumers = topicConsumers.computeIfAbsent(getTopicKey(exchangeName, routingKey), k -> new ArrayList<>());
        consumers.add(consumer);
    }

    private void notifyConsumers(String exchangeName, String routingKey, Message message) {
        String topicKey = getTopicKey(exchangeName, routingKey);
        List<Consumer> consumers = topicConsumers.getOrDefault(topicKey, new ArrayList<>());

        for (Consumer consumer : consumers) {
            new Thread(() -> {
                consumer.consume(message);
            }).start();
        }
    }

    private String getTopicKey(String exchangeName, String routingKey) {
        return exchangeName + ":" + routingKey;
    }
}
