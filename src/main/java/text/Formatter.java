package text;

import java.util.Map;

public class Formatter {

    private static final char SPACE = ' ';
    private static final char DASH = '-';
    private static final char QUOTES = '"';
    private static final char NEWLINE='\n';

    public String createLinesForFormatting(Map<Character,Integer> map) {
        var outputResult = new StringBuilder();
        map.keySet()
                .forEach(e -> outputResult.append(QUOTES)
                .append(e)
                .append(QUOTES)
                .append(SPACE)
                .append(DASH)
                .append(SPACE)
                .append(map.get(e))
                .append(NEWLINE));
        return outputResult.toString();
    }
}
