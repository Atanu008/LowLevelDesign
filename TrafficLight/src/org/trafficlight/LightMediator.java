package org.trafficlight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LightMediator {


    Map<Color, Light> lightMap;

    public LightMediator(){
        lightMap = new HashMap<>();
    }

    /**
     * register passed light object in LightMediator
     * It is being called by constructor of Light class.
     * We can also explicitly call this method.
     */
    public void registerLight(Light light){
        lightMap.put(light.getColor(), light);
    }

    /**
     * unregisters light from LightMediator
     */
    public void unregisterLight(Light light){
        lightMap.remove(light.getColor());
    }

    /**
     * Turns off all the lights other than
     * passed light Object
     */
    public void turnOffAllOtherLights(Light currentLight){

        for(Light light : lightMap.values()){
            if(!light.equals(currentLight)){
                light.turnOFF();
            }
        }
    }

    public void turnON(Light currentLight){
        turnOffAllOtherLights(currentLight); //Turn OFF other lights
        currentLight.turnON();
    }


    public void turnONLight(Color color){
        turnON(lightMap.get(color));
    }
}
