package org.behavioral.observer.promotion;

import java.util.*;

//This is the concrete implementation of subject aka Publisher
public class NotificationService implements Subject{

    Map<EventType, List<Listner>> listnersByEventType;

    public NotificationService(){
        listnersByEventType = new HashMap<>();
        //Need Arrays.stream to iterate over Enum values
        Arrays.stream(EventType.values()).forEach(eventType -> listnersByEventType.put(eventType, new ArrayList<>()));
    }

    @Override
    public void subscribe(EventType eventType, Listner listner) {
        listnersByEventType.get(eventType).add(listner);
    }

    @Override
    public void unsubscribe(EventType eventType, Listner listner) {
        listnersByEventType.get(eventType).remove(listner);
    }

    @Override
    public void notifyListners(EventType eventType) {
        listnersByEventType.get(eventType).forEach(listner -> listner.update(eventType));
    }
}
