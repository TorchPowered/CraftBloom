package org.bloom.event;

import org.apache.commons.lang3.Validate;
import org.bloom.Bloom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A event manager
 */
public class EventManager {
    public static Map<Class, Method> eventMethods = new HashMap<Class, Method>();
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
                if(parameterClass.isAssignableFrom(Event.class)){
                    eventMethods.put(listenerClass, method);
                }
            }
        }
    }

    public void registerEventClass(Class eventClass){
        if(eventClass.isAssignableFrom(Event.class)){
            eventClasses.add(eventClass);
        }
    }

    public void callEvent(Event event){
        Validate.notNull(event);
        for (Map.Entry<Class, Method> methodEntry : eventMethods.entrySet()){
            Method method = methodEntry.getValue();
            Class theClassDeclaring = methodEntry.getKey();
            Class[] parameters = method.getParameterTypes();
            for(Class parameter : parameters){
                for (Class eventClass : eventClasses){
                    if(eventClass == parameter){
                        try {
                            method.invoke(theClassDeclaring, method);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
