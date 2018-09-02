package events;

import java.util.List;

public interface IEventDispatcher{

    public void register(IEventHandler handler);

    public void unregister(IEventHandler handler);

    public void notifyObservers();
}
