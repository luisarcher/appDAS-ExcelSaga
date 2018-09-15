package events;

import controllers.command.ICommand;

public interface IEventHandler {

    void handle(ICommand command);

}

