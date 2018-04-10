package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.Command;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.Renderer;
import com.google.inject.Inject;

public class CommandManager {
    private DrawingBoard drawingBoard;
    private Renderer renderer;

    @Inject
    public CommandManager(Renderer renderer){
        this.renderer = renderer;
    }

    public String execute(Command command) {
        String errorMessage = "";
        CanvasCommand canvasCommand = command instanceof CanvasCommand ? (CanvasCommand) command: null;

        if(command instanceof CanvasCommand) {
             canvasCommand = (CanvasCommand)command;
        }


        if(canvasCommand != null) {
            this.drawingBoard = new DrawingBoard(canvasCommand.getLength(), canvasCommand.getHeight());
        }


        if (this.drawingBoard == null) {
            errorMessage = ExceptionMessages.CANVAS_NOT_DRAWN;
        }
        else {
            errorMessage = command.getShape().Draw(this.drawingBoard);
            this.renderer.render(this.drawingBoard.toString());
        }
        return errorMessage;
    }

}
