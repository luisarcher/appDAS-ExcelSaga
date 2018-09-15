package events;

import controllers.command.ICommand;

public interface IEventDispatcher{

    void register(IEventHandler handler);

    void unregister(IEventHandler handler);

    void notifyObservers(ICommand command);
}
