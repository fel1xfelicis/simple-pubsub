package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Consumer {

    private List<String> subbedTopics;
    private Map<String, Integer> startConsume;

    public Consumer() {
        subbedTopics = new ArrayList<>();
        startConsume = new ConcurrentHashMap<>();
    }

    public boolean subscribeToNewTopic(String topicName) {
        subbedTopics.add(topicName);
        startConsume.put(topicName, 0);
        return true;
    }

    public void consume() {
        subbedTopics.stream().forEach(topicName -> {
            Integer toStart = startConsume.get(topicName);
            List<String> messages = Topics.getMessagesFromIndex(topicName, toStart);
            for (String message : messages) {
                System.out.println(topicName + ": " + message);
            }
            startConsume.put(topicName, toStart + messages.size());
        });
    }

    public boolean unsub(String topicName) {
        for (int i=0; i<subbedTopics.size(); i++) {
            if (subbedTopics.get(i).equals(topicName)) {
                subbedTopics.remove(i);
            }
        }
        return true;
    }

}
