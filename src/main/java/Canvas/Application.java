package Canvas;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {

    public static void main(String[] args){
        Injector injector = Guice.createInjector(new CanvasModule());
        System.out.println("Started Simple CanvasShape!");
        UserInputHandler userInputHandler = injector.getInstance(UserInputHandler.class);
        userInputHandler.handleUserIO();
    }



}
