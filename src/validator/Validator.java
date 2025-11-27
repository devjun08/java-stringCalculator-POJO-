package validator;

import static exception.ErrorMessage.*;

public class Validator {
    public static void validateAll(String input) {
        validateNull(input);
        validateSeparator(input);
        validateOperator(input);
        divideByZero(input);
    }

    public static void validateSeparator(String input) {
        final int OPERATOR_INDEX = input.length() - 1;
        for (int i = 0; i < OPERATOR_INDEX; i++) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);
        }
    }

    public static void validateOperator(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }

    }
    public static void divideByZero(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }

    }
    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }

    }
}
