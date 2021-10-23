package model;

public class Publisher {

    public boolean publishNewMessage(String topicName, String message) {
        if (Topics.publishMessageToTopic(topicName, message)) {
            return true;
        }
        return false;
    }

}
