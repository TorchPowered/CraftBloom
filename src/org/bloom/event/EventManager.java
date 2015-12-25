package org.bloom.event;

import org.apache.commons.lang3.Validate;
import org.bloom.Bloom;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * A event manager
 */
public class EventManager {
    public static ArrayList<Method> eventMethods = new ArrayList<Method>();
    public static ArrayList<Class> eventClasses = new ArrayList<Class>();

    public EventManager(Bloom bloom){
        Validate.notNull(bloom);
    }

    /**
     * Registers a listener class
     * @param listenerClass the listener class
     */
    public void registerListenerClass(Class listenerClass){
        Method[] allMethods = listenerClass.getDeclaredMethods();
        for (Method method : allMethods){
            Class[] parameterClasses = method.getParameterTypes();
            for(Class parameterClass : parameterClasses){
                if(Event.class.isAssignableFrom(parameterClass)){
                    eventMethods.add(method);
                }
            }
        }
    }

    public void registerEventClass(Class eventClass){
        if(Event.class.isAssignableFrom(eventClass)){
            eventClasses.add(eventClass);
        }
    }

    public void callEvent(Event event){
        Validate.notNull(event);
        for (Method method : eventMethods){
            for(Class parameterClass : method.getParameterTypes()) {
                if (parameterClass == PlayerJoinEvent.class && event instanceof PlayerJoinEvent) {
                    try {
                        method.invoke(method.getDeclaringClass().newInstance(), (PlayerJoinEvent) event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (parameterClass == PlayerLeaveEvent.class && event instanceof PlayerLeaveEvent) {
                    try {
                        method.invoke(method.getDeclaringClass().newInstance(), (PlayerLeaveEvent) event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(parameterClass == PluginStartingEvent.class && event instanceof PluginStartingEvent){
                    try {
                        method.invoke(method.getDeclaringClass().newInstance(), (PluginStartingEvent) event);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(parameterClass == PlayerMoveEvent.class && event instanceof PlayerMoveEvent){
                    try{
                        method.invoke(method.getDeclaringClass().newInstance(), (PlayerMoveEvent) event);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(parameterClass == PluginStopEvent.class && event instanceof PluginStopEvent){
                    try{
                        method.invoke(method.getDeclaringClass().newInstance(), (PluginStopEvent) event);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
