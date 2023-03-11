package org.factory.card;

public class CardFactory {
    public static Card getcard(String type){
        switch(type){
            case "Silver":
                return new SilverCard();
            case "Gold":
                return new GoldCard();
            case "Platinum":
                return new PlatinumCard();
            default :
                return null;
        }
    }
}
