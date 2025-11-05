package validator;

public class Validator {
    // 숫자 배열 검증: 음수나 0 미만 숫자 허용하지 않음 예시
    public void validateNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("숫자 배열이 비어있습니다.");
        }
        for (int num : numbers) {
            if (num <= 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 허용되지 않습니다: " + num);
            }
        }
    }

    // 연산자 검증: + - * / 만 허용
    public void validateOperator(String operator) {
        if (operator == null || !operator.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("허용되지 않은 연산자입니다: " + operator);
        }
    }
}
