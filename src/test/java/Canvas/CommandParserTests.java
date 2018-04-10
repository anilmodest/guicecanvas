package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.Command;
import Canvas.Commands.LineCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandParserTests {

    private Set<Command> supportedCommands;
    @Before
    public void Init(){
        this.supportedCommands = new HashSet<>();
        supportedCommands.add(new CanvasCommand());
        supportedCommands.add(new LineCommand());
    }

    @Test
    public void parse_canvas_command(){

        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<Command> cmd = cmdParser.parseCommand("C 2 2");
        Assert.assertTrue(cmd.get() instanceof CanvasCommand);
    }

    @Test
    public void parse_invalid_command(){

        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<Command> cmd = cmdParser.parseCommand("D 2 2");
        Assert.assertFalse(cmd.isPresent());
    }

    @Test
    public void parse_line_command(){
        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<Command> cmd = cmdParser.parseCommand("L 1 1 1 2");
        Assert.assertTrue(cmd.get() instanceof LineCommand);
    }
}
