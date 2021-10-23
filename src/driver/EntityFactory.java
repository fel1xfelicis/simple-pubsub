package driver;

import model.Consumer;
import model.Publisher;
import model.Topics;

import java.util.List;

public class EntityFactory {

    public static Publisher getNewPub() {
        return new Publisher();
    }

    public static boolean createNewTopics(List<String> topicNames) {
        topicNames.stream().forEach(name -> Topics.createTopic(name));
        return true;
    }

    public static Consumer getNewConsumer() {
        return new Consumer();
    }

}
