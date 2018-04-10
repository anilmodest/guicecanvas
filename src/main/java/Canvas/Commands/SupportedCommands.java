package Canvas.Commands;

import java.util.HashMap;
import java.util.regex.Pattern;

public class SupportedCommands {
    public static final Pattern CANVAS_COMMAND = Pattern.compile("^[C|c]\\s(?<Length>\\d+)\\s(?<Height>\\d+)$");
    public static final Pattern LINE_COMMAND = Pattern.compile("^[L|l]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<X2>\\d+)\\s(?<Y2>\\d+)$");
    public static final Pattern RECTANGLE_COMMAND = Pattern.compile("^[R|r]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<X2>\\d+)\\s(?<Y2>\\d+)$");
    public static final Pattern BUCKETFILL_COMMAND = Pattern.compile("^[B|b]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<C>.)$");
    public static final Pattern HELP_COMMAND = Pattern.compile("^[h|H]");
    public static final Pattern QUIT_COMMAND = Pattern.compile("^[q|Q]");
    public static final Pattern UNDO_COMMAND = Pattern.compile("^[u|U]");
    public static final Pattern REDO_COMMAND = Pattern.compile("^[r|R]");

}
