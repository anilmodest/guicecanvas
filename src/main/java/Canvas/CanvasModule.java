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

        Multibinder<Command> commands = Multibinder.newSetBinder(binder(), Command.class);
        commands.addBinding().to(CanvasCommand.class);
        commands.addBinding().to(LineCommand.class);
        commands.addBinding().to(RectangleCommand.class);
        commands.addBinding().to(BucketFillCommand.class);
        commands.addBinding().to(HelpCommand.class);
        commands.addBinding().to(QuitCommand.class);
        commands.addBinding().to(RedoCommand.class);
        commands.addBinding().to(UndoCommand.class);

    }



}
