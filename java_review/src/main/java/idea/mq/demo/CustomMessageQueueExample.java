package idea.mq.demo;

import java.util.*;

class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Topic {
    private final Map<String, List<Message>> routingKeyToMessages;

    public Topic() {
        routingKeyToMessages = new HashMap<>();
    }

    public void addMessage(String routingKey, Message message) {
        List<Message> messages = routingKeyToMessages.computeIfAbsent(routingKey, k -> new ArrayList<>());
        messages.add(message);
        synchronized (messages) {
            messages.notify(); // 通知等待的消费者
        }
    }

    public Message getMessageForRoutingKey(String routingKey) throws InterruptedException {
        List<Message> messages = routingKeyToMessages.getOrDefault(routingKey, new ArrayList<>());
        synchronized (messages) {
            while (messages.isEmpty()) {
                messages.wait(); // 等待消息到达
            }
            return messages.remove(0);
        }
    }
}

class Exchange {
    private final Map<String, Topic> topics;

    public Exchange() {
        topics = new HashMap<>();
    }

    public void createTopic(String topicName) {
        topics.put(topicName, new Topic());
    }

    public Topic getTopic(String topicName) {
        return topics.get(topicName);
    }
}

class MessageQueue {
    private final Exchange exchange;

    public MessageQueue() {
        this.exchange = new Exchange();
    }

    public void createTopic(String topicName) {
        exchange.createTopic(topicName);
    }

    public void publish(String exchangeName, String routingKey, Message message) {
        exchange.getTopic(exchangeName).addMessage(routingKey, message);
    }

    public Message subscribe(String exchangeName, String routingKey) throws InterruptedException {
        return exchange.getTopic(exchangeName).getMessageForRoutingKey(routingKey);
    }
}

public class CustomMessageQueueExample {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.createTopic("topicA");

        new Thread(() -> {
            try {
                Message receivedMessage = messageQueue.subscribe("topicA", "key1");
                System.out.println("Received message on topicA key1: " + receivedMessage.getContent());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Simulating message being published
        Message message1 = new Message("Message 1");
        messageQueue.publish("topicA", "key1", message1);
    }
}
