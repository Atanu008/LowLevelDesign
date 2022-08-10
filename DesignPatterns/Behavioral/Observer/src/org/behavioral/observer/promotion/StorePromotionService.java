package org.behavioral.observer.promotion;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-behavioral-observer/src/com/youtube/geekific/MainApp.java
public class StorePromotionService {

    public static void main(String[] args) {

        Store store = new Store();

        store.getNotificationService().subscribe(EventType.NEW_ITEM, new EmailMessageListner("abc@gmail.com"));
        store.getNotificationService().subscribe(EventType.SALE, new EmailMessageListner("xyz@gmail.com"));

        store.getNotificationService().subscribe(EventType.NEW_ITEM, new MobileAppListner("Atanu"));
        Listner mobileListner = new MobileAppListner("Riju");
        store.getNotificationService().subscribe(EventType.SALE, mobileListner);

        store.addNewItem();
        System.out.println("===============================================================");
        store.addNewSale();

        System.out.println("===============================================================");
        store.getNotificationService().unsubscribe(EventType.SALE, mobileListner);
        store.addNewSale();
    }
}
