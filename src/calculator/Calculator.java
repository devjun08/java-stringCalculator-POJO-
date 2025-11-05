package calculator;

public class Calculator {
    // 숫자 배열과 연산자를 받아 계산 수행
    public double calculate(int[] numbers, String operator) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("계산할 숫자가 없습니다.");
        }

        double result = numbers[0];  // 초깃값 double로 선언

        for (int i = 1; i < numbers.length; i++) {
            switch (operator) {
                case "+":
                    result += numbers[i];
                    break;
                case "-":
                    result -= numbers[i];
                    break;
                case "*":
                    result *= numbers[i];
                    break;
                case "/":
                    if (numbers[i] == 0) {
                        throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                    }
                    result /= numbers[i];  // double 나눗셈
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자: " + operator);
            }
        }
        return Math.round(result * 10) / 10.0;  // 소수 첫째자리에서 반올림
    }
}
