package idea.mq;

import java.util.HashMap;
import java.util.Map;

public class Exchange {
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
