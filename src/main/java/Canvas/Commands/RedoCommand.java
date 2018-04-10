package Canvas.Commands;

import Canvas.Shapes.Shape;

import java.util.regex.Matcher;

public class RedoCommand implements Command {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.REDO_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
