package input;

import java.util.Scanner;
import validator.Validator;

public class Input {
    private static Scanner scanner;

    private Input() {}

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static String nextLine() {
        String input = getInstance().nextLine();

        Validator.AllValidate(input);

        return input;
    }
}
