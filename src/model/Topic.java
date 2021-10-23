package model;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private List<Message> messages;
    private static int currentId = 0;

    Topic() {
        messages = new ArrayList<>();
    }

    public boolean addMessage(String message) {
        Message toAdd = new Message();
        toAdd.setId(currentId);
        toAdd.setMessage(message);
        messages.add(toAdd);
        currentId++;
        return true;
    }

    public List<String> getMessagesFromIndex(int start) {
        List<String> toConsume = new ArrayList<>();
        for (int i=start; i<messages.size(); i++) {
            toConsume.add(messages.get(i).getMessage());
        }
        return toConsume;
    }

}
