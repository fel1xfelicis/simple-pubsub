package driver;

import model.Consumer;
import model.Publisher;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> topicList = new ArrayList<>();
        topicList.add("Cars");
        topicList.add("Bikes");
        EntityFactory.createNewTopics(topicList);
        Publisher carPub1 = EntityFactory.getNewPub();
        Publisher carPub2 = EntityFactory.getNewPub();
        Publisher bikePub1 = EntityFactory.getNewPub();
        carPub1.publishNewMessage("Cars", "Maruti");

        Consumer consumer1 = EntityFactory.getNewConsumer();
        consumer1.subscribeToNewTopic("Cars");
        consumer1.consume();

        carPub2.publishNewMessage("Cars", "Toyota");
        consumer1.consume();

        Consumer consumer2 = EntityFactory.getNewConsumer();
        consumer2.subscribeToNewTopic("Cars");
        consumer2.consume();

        bikePub1.publishNewMessage("Bikes", "Honda");
        consumer1.consume();
        System.out.println("Now let's sub");
        consumer1.subscribeToNewTopic("Bikes");
        consumer1.consume();

        carPub1.publishNewMessage("Cars", "Venus");
        consumer1.consume();

        carPub1.publishNewMessage("Cars", "Latest");
        consumer1.unsub("Cars");
        bikePub1.publishNewMessage("Bikes", "Honda");
        consumer1.consume();
    }

}
