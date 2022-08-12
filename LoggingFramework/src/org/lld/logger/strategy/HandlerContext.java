package org.lld.logger.strategy;

import lombok.Getter;
import org.lld.logger.enums.HandlerType;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HandlerContext {

    private static Map<HandlerType, Handler> handlerMap = new HashMap<>();

    public HandlerContext(){

    }

    static {
        handlerMap.put(HandlerType.CONSOLE, new ConsoleHandler());
        handlerMap.put(HandlerType.FILE, new FileHandler());
        handlerMap.put(HandlerType.DATABASE, new DataBaseHandler());
    }

    public static Handler getRegisteredHandler(HandlerType handlerType){
        return handlerMap.get(handlerType);
    }

    public static void registeredHandler(HandlerType handlerType, Handler handler){
        handlerMap.put(handlerType, handler);
    }
}
