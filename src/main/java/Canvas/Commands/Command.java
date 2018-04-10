package Canvas.Commands;

import Canvas.Shapes.Shape;

public interface Command {
    Boolean isValid(String cmd);
    Shape getShape();
}
