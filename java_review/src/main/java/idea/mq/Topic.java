package idea.mq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    private final Map<String, List<Message>> routingKeyToMessages;

    public Topic() {
        routingKeyToMessages = new HashMap<>();
    }

    public void addMessage(String routingKey, Message message) {
        routingKeyToMessages.computeIfAbsent(routingKey, k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRoutingKey(String routingKey) {
        return routingKeyToMessages.getOrDefault(routingKey, new ArrayList<>());
    }
}
