package utils.events;

import controllers.command.ICommand;

import java.util.LinkedList;
import java.util.List;

public class EventDispatcher implements IEventDispatcher{

    private List<IEventHandler> listeners;

    public EventDispatcher(){

        this.listeners = new LinkedList<IEventHandler>();
    }

    public void register(IEventHandler handler){

        this.listeners.add(handler);
    }

    public void unregister(IEventHandler handler){

        this.listeners.remove(handler);
    }

    public void notifyObservers(ICommand command){

        for (IEventHandler handler : listeners){
            handler.handle(command);
        }
    }
}
