package stringCalculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("계산할 문자열을 입력하세요. (예: 1,2:3 +)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("입력된 값: " + input);

        // 이곳에서 calculate연산 호출할것
    }
}
