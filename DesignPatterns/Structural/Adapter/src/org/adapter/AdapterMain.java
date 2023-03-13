package org.adapter;

//https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-adapter/src/main/java/com/youtube/geekific/MainApp.java
//https://www.youtube.com/watch?v=wA3keqCeKtM&list=PLlsmxlJgn1HJpa28yHzkBmUY-Ty71ZUGc&index=18

public class AdapterMain {

    public static void main(String[] args) {

        XmlData xmlData = new XmlData();

        IMultiRestoApp multiRestoApp = new MultiRestoApp();
        multiRestoApp.displayMenu(xmlData);
        multiRestoApp.displayRecommendations(xmlData);


        IMultiRestoApp adapter = new FancyUIAdapter();
        adapter.displayMenu(xmlData);
        adapter.displayRecommendations(xmlData);
    }
}
