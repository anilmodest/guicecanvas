package Canvas;

import Canvas.Commands.CanvasCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Commands.LineCommandWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CommandParserTests {

    private Set<CommandWrapper> supportedCommands;
    @Before
    public void Init(){
        this.supportedCommands = new HashSet<>();
        supportedCommands.add(new CanvasCommandWrapper());
        supportedCommands.add(new LineCommandWrapper());
    }

    @Test
    public void parse_canvas_command(){

        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("C 2 2");
        Assert.assertTrue(cmd.get() instanceof CanvasCommandWrapper);
    }

    @Test
    public void parse_invalid_command(){

        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("D 2 2");
        Assert.assertFalse(cmd.isPresent());
    }

    @Test
    public void parse_line_command(){
        CommandParser cmdParser = new CommandParser(this.supportedCommands);
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("L 1 1 1 2");
        Assert.assertTrue(cmd.get() instanceof LineCommandWrapper);
    }
}
