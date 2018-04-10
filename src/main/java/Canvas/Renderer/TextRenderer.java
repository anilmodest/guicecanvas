package Canvas.Renderer;

import com.google.inject.Inject;

public class TextRenderer implements Renderer {
    private Console console;

    @Inject
    public TextRenderer(Console console) {

        this.console = console;
    }

    @Override
    public void render(String printText) {
        this.console.print(printText);
    }

}
