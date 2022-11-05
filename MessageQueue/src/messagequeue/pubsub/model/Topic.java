package messagequeue.pubsub.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Topic {

    private final String topicId;
    private final String topicName;
    private final List<Message> messages;
    private final List<TopicSubscriber> subscribers;

    public Topic(String topicName) {
        this.topicId = UUID.randomUUID().toString();
        this.topicName = topicName;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull final Message message){
        messages.add(message);
    }

    public void addSubscriber(@NonNull final TopicSubscriber topicSubscriber){
        subscribers.add(topicSubscriber);
    }
}
