package org.behavioral.observer.promotion;

public class Store {

    private final Subject notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    public void addNewItem(){
        notificationService.notifyListners(EventType.NEW_ITEM);
    }

    public void addNewSale(){
        notificationService.notifyListners(EventType.SALE);
    }

    public Subject getNotificationService() {
        return notificationService;
    }
}
