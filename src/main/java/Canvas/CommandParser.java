package Canvas;

import Canvas.Commands.*;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private List<CommandWrapper> supportedCommands;
    private Set<CommandWrapper> commandWrappers;

    @Inject
    public CommandParser(Set<CommandWrapper> commandWrappers){
        this.commandWrappers = commandWrappers;
    }

    public Optional<CommandWrapper> parseCommand(String cmdText) {
        return this.commandWrappers.stream().filter(cw -> cw.isValid(cmdText)).findFirst();
    }
}
