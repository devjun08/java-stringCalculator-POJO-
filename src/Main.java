import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Input:");
            String input = scanner.nextLine();

            // 1) 파싱
            Parser parser = new Parser();
            List<Integer> parsedData = parser.parseInput(input);

            // 2) 검증
            Validator validator = new Validator();
            validator.validate(parsedData);

            // 3) 계산
            Calculator calculator = new Calculator();
            int result = calculator.calculate(parsedData);

            // 4) 결과 출력
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
