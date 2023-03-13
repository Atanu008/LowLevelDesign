package org.decorator.notification;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-decorator/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=v6tpISNjHf8&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=20

public class DecoratorMain {
    public static void main(String[] args) {

        INotifier notifyViaEmailAndAllOther = new FacebookDecorator(new WhatsAppDecorator(new EmailNotifier("Atanu")));
        notifyViaEmailAndAllOther.send("Please dont forget decorator pattern :)");

        System.out.println("==========================================");

        INotifier notifyViaPhoneAndAllOther = new FacebookDecorator(new WhatsAppDecorator(new MessageNotifier("Riju")));
        notifyViaPhoneAndAllOther.send("Please dont forget decorator");

        System.out.println("==========================================");

        INotifier notifyFbMail = new FacebookDecorator(new EmailNotifier("Geekific"));
        notifyFbMail.send("Like and Subscribe!!!");

        INotifier notifyFbPhone = new FacebookDecorator(new MessageNotifier("987"));
        notifyFbPhone.send("Share please!!!");
    }
}
