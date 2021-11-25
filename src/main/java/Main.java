import count.BasicCharCounter;
import count.CashCharCounter;
import model.Result;
import text.Formatter;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        BasicCharCounter basicCharCounter = new BasicCharCounter();
        CashCharCounter cashCharCounter = new CashCharCounter(basicCharCounter);
        Result result = new Result(basicCharCounter, formatter, cashCharCounter);

        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();

//        while (!"/exit".equals(inputWord)) {
//            System.out.println(result.buildResultWithoutCache(inputWord));
//            System.out.println(result.buildResultWithCache(inputWord));
//            inputWord = scanner.nextLine();
//
//        }
        for (int i = 0; i < 1000000; i++) {
            basicCharCounter.fillMap(inputWord);
        }
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 1000000; i++) {
            cashCharCounter.fillMap(inputWord);

        }
    }
}
