package Canvas.Commands;

import Canvas.Shapes.Shape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;

public class QuitCommand implements Command {


    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.QUIT_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public Shape getShape() {
        throw new NotImplementedException();
    }
}
