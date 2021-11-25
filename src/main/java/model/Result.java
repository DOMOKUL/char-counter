package model;

import count.BasicCharCounter;
import count.CashCharCounter;
import text.Formatter;

import java.util.Map;

public class Result {

    private final BasicCharCounter basicCharCounter;
    private final Formatter formatter;
    private final CashCharCounter cashCharCounter;

    public Result(BasicCharCounter basicCharCounter, Formatter formatter, CashCharCounter cashCharCounter) {
        this.basicCharCounter = basicCharCounter;
        this.formatter = formatter;
        this.cashCharCounter = cashCharCounter;
    }

    public String buildResultWithoutCache(String text) throws IllegalArgumentException {
        if (text==null || text.equals("")) {
            throw new IllegalArgumentException("You should input string");
        }
        Map<Character,Integer> basicMap = basicCharCounter.fillMap(text);
        return formatter.createLinesForFormatting(basicMap);
    }

    public String buildResultWithCache(String text) throws IllegalArgumentException{
        if (text==null || text.equals("")) {
            throw new IllegalArgumentException("You should input string");
        }
        Map<Character,Integer> cacheMap = cashCharCounter.fillMap(text);
        return formatter.createLinesForFormatting(cacheMap);
    }
}
