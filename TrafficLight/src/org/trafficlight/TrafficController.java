package org.trafficlight;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {

    final private Map<Direction, LightMediator> directionLightMediatorMap;
    final static private Map<Direction, Direction> directionMapper = new HashMap<>();

    static{
        directionMapper.put(Direction.East, Direction.West);
        directionMapper.put(Direction.West, Direction.East);

        directionMapper.put(Direction.North, Direction.South);
        directionMapper.put(Direction.South, Direction.North);
    }

    public TrafficController(){
        directionLightMediatorMap = new HashMap<>();
    }


    public void addlightMediator(Direction direction, LightMediator lightMediator){
        directionLightMediatorMap.put(direction, lightMediator);
    }

    public void startTraffic(Direction startDirection){

        //Initially Turn ON Red Light of All the Signals
        directionLightMediatorMap.values().forEach(lightMediator -> lightMediator.turnONLight(Color.RED));
        //To Do
        while (true){

        }
    }
}
