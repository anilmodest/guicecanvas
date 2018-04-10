package Canvas;

import Canvas.Commands.*;
import Canvas.Renderer.Console;
import Canvas.Renderer.Renderer;
import Canvas.Renderer.SystemConsole;
import Canvas.Renderer.TextRenderer;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class CanvasModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer.class).to(TextRenderer.class);
        bind(Console.class).to(SystemConsole.class);

        Multibinder<Command> supportedCommander = Multibinder.newSetBinder(binder(), Command.class);
        supportedCommander.addBinding().to(CanvasCommand.class);
        supportedCommander.addBinding().to(LineCommand.class);
        supportedCommander.addBinding().to(RectangleCommand.class);
        supportedCommander.addBinding().to(BucketFillCommand.class);
        supportedCommander.addBinding().to(HelpCommand.class);
        supportedCommander.addBinding().to(QuitCommand.class);
        supportedCommander.addBinding().to(RedoCommand.class);
        supportedCommander.addBinding().to(UndoCommand.class);

    }



}
