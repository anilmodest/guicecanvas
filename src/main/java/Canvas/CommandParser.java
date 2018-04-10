package Canvas;

import Canvas.Commands.*;
import com.google.inject.Inject;

import java.util.*;

public class CommandParser {

    private Set<Command> commands;

    @Inject
    public CommandParser(Set<Command> commands){
        this.commands = commands;
    }

    public Optional<Command> parseCommand(String cmdText) {
        return this.commands.stream().filter(cw -> cw.isValid(cmdText)).findFirst();
    }
}
