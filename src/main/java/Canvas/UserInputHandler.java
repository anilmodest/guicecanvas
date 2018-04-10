package Canvas;

import Canvas.Commands.Command;
import Canvas.Commands.HelpCommand;
import Canvas.Commands.QuitCommand;
import Canvas.Exceptions.ExceptionMessages;
import com.google.inject.Inject;

import java.util.Optional;
import java.util.Scanner;

public class UserInputHandler {
    private CommandParser commandParser;
    private CommandManager commandManager;

    @Inject
    public UserInputHandler(CommandParser commandParser, CommandManager commandManager) {
        this.commandParser = commandParser;
        this.commandManager = commandManager;
    }

    public void handleUserIO(){
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.printf("Please enter command: ");
                String cmdText = scanner.nextLine().trim();
                Optional<Command> optionalCommand = commandParser.parseCommand(cmdText);
                if (optionalCommand.isPresent()) {
                    Command cmd = optionalCommand.get();

                    if (cmd instanceof QuitCommand) {
                        System.exit(0);
                    } else if (cmd instanceof HelpCommand) {
                        helpText();
                    } else {

                        try {
                            String errorMessage = commandManager.execute(cmd);
                            if(errorMessage.length() > 0) {
                                System.out.println(errorMessage);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                else {
                    System.out.println(ExceptionMessages.INVALID_COMMAND);
                }

            }


        }
    }

    private static void helpText() {
        System.out.println("**********************CanvasShape***********************");
        System.out.println("Supported Commands:");
        System.out.println("Draw CanvasShape: C|c l h");
        System.out.println("Draw CanvasShape: L|l x1 y1 x2 y2");
        System.out.println("Draw CanvasShape: R|r x1 y1 x2 y2");
        System.out.println("Draw CanvasShape: B|b x y");
        System.out.println("Quit: Q|q");
        System.out.println("Help : H|h");
    }
}
