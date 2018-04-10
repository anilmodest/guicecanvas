package Canvas.Commands;

import Canvas.Shapes.Shape;

import java.util.regex.Matcher;

public class UndoCommand implements Command {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.UNDO_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
