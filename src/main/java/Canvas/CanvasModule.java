package Canvas;

import Canvas.Commands.*;
import Canvas.Renderer.Console;
import Canvas.Renderer.Renderer;
import Canvas.Renderer.SystemConsole;
import Canvas.Renderer.TextRenderer;
import Canvas.Shapes.LineShape;
import Canvas.Shapes.Shape;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Named;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CanvasModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Renderer.class).to(TextRenderer.class);
        bind(Console.class).to(SystemConsole.class);

        Multibinder<CommandWrapper> supportedCommander = Multibinder.newSetBinder(binder(), CommandWrapper.class);
        supportedCommander.addBinding().to(CanvasCommandWrapper.class);
        supportedCommander.addBinding().to(LineCommandWrapper.class);
        supportedCommander.addBinding().to(RectangleCommandWrapper.class);
        supportedCommander.addBinding().to(BucketFillCommandWrapper.class);
        supportedCommander.addBinding().to(HelpCommandWrapper.class);
        supportedCommander.addBinding().to(QuitCommandWrapper.class);
        supportedCommander.addBinding().to(RedoCommandWrapper.class);
        supportedCommander.addBinding().to(UndoCommandWrapper.class);

    }



}
