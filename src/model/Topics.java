package model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Topics {

    private static Map<String, Topic> topicMap;

    static {
        topicMap = new ConcurrentHashMap<>();
    }

    public static boolean createTopic(String topicName) {
        Topic toAdd = new Topic();
        topicMap.put(topicName, toAdd);
        return true;
    }

    public static boolean publishMessageToTopic(String topic, String message) {
        topicMap.get(topic).addMessage(message);
        return true;
    }

    public static List<String> getMessagesFromIndex(String topicName, Integer start) {
        Topic topic = topicMap.get(topicName);
        return topic.getMessagesFromIndex(start);
    }

}
