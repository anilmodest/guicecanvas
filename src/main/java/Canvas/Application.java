package Canvas;

import Canvas.Commands.HelpCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Commands.QuitCommandWrapper;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.TextRenderer;
import Canvas.Renderer.SystemConsole;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Injector injector = Guice.createInjector(new CanvasModule());
        System.out.println("Started Simple CanvasShape!");
        UserInputHandler userInputHandler = injector.getInstance(UserInputHandler.class);
        userInputHandler.handleUserIO();
    }



}
