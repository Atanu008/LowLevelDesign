package messagequeue.pubsub.handler;

import lombok.NonNull;
import lombok.SneakyThrows;
import messagequeue.pubsub.model.Message;
import messagequeue.pubsub.model.Topic;
import messagequeue.pubsub.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(@NonNull Topic topic, @NonNull TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows //can be used to sneakily throw checked exceptions without actually declaring this in your method's throws clause.
    @Override
    public void run() {

        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }

                Message messgae = topic.getMessages().get(curOffset);
                topicSubscriber.getSubscriber().consume(messgae);

                // We cannot just increment here since subscriber offset can be reset while it is consuming. //Still have doubt????
                // So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);
            }
            while (true);
        }
    }

    public void  wakeupIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
