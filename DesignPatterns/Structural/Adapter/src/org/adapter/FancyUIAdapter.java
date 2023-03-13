package org.adapter;

// This is the new Adapter which is required to be adapted to use old XML data
// here FancyUIService is a JSON data handling class. As we need to use XmlData in the APP
// from User end, so we need to use this implemented based class to convert the XML to JSON
public class FancyUIAdapter implements IMultiRestoApp{

    private final FancyUIService fancyUIService;

    public FancyUIAdapter() {
        this.fancyUIService = new FancyUIService();
    }

    @Override
    public void displayMenu(XmlData xmlData) {
        JsonData jsonData = convertXmlToJsonData(xmlData);
        System.out.println("Preparing Fancy Menus using converted JSON data Adapter...");
        fancyUIService.displayMenu(jsonData);
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        JsonData jsonData = convertXmlToJsonData(xmlData);
        System.out.println("Preparing Fancy Recommendations using converted JSON data Adapter...");
        fancyUIService.displayRecommendations(jsonData);
    }

    private JsonData convertXmlToJsonData(XmlData jsXmlData){
        // Converts XmlData to JsonData and return it
        System.out.println("Converting XML to JSON...");
        return new JsonData();
    }
}
