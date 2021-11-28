import com.company.charcounter.count.BasicCharCounter;
import com.company.charcounter.count.CacheCharCounter;
import com.company.charcounter.text.Formatter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        BasicCharCounter basicCharCounter = new BasicCharCounter();
        CacheCharCounter cacheCharCounter = new CacheCharCounter(basicCharCounter);

        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();

        while (!"/exit".equals(inputWord)) {
            System.out.println(formatter.createLinesForOutput(basicCharCounter.countInternal(inputWord), inputWord));
            System.out.println(formatter.createLinesForOutput(cacheCharCounter.countInternal(inputWord), inputWord));
            inputWord = scanner.nextLine();

        }
    }
}



