package idea.mq;

public class CustomMessageQueueExample {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.createTopic("topicA");
        messageQueue.createTopic("topicB");

        messageQueue.subscribe("topicA", "key1", message -> {
            System.out.println("Received message on topicA key1: " + message.getContent());
        });

        messageQueue.subscribe("topicB", "key1", message -> {
            System.out.println("Received message on topicB key1: " + message.getContent());
        });

        // Simulating messages being published
        Message message1 = new Message("Message 1");
        Message message2 = new Message("Message 2");

        messageQueue.publish("topicA", "key1", message1);
        messageQueue.publish("topicB", "key1", message2);
    }
}