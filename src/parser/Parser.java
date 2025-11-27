package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import exception.ErrorMessage;

public class Parser {

    private static final String NUMBER_PATTERN = "^[0-9]*\\.?[0-9]*$";

    // 멤버 변수 (파싱된 결과 저장)
    private List<Integer> numbers;
    private String operatorSymbol;

    // depth: 1
    public void StringParser() {
        this.numbers = new ArrayList<>();
        this.operatorSymbol = "";
    }

    /**
     * 입력 문자열을 파싱하여 숫자 리스트와 연산자 심볼을 멤버 변수에 저장합니다.
     * (단일 메서드로 파싱을 완료)
     * @param input 검증된 입력 문자열
     */
    // depth: 1
    public void parse(String input) {
        String trimmedInput = input.trim();
        String[] parts = trimmedInput.split(" ");

        // parts[0] = 숫자 덩어리, parts[1] = 연산자 심볼 (Validator에서 이미 검증됨)
        this.operatorSymbol = parts[1];

        parseNumbersInternal(parts[0]);
    }

    // depth: 1: 숫자 부분 파싱 및 멤버 변수 numbers에 저장
    private void parseNumbersInternal(String numbersPart) {
        // 쉼표(,) 또는 콜론(:)을 구분자로 분리
        String[] numberTokens = numbersPart.split("[:,]");

        for (String token : numberTokens) { // depth: 1
            if (token.isEmpty()) { // depth: 2
                continue;
            }
            validateAndAddNumber(token);
        }
    }

    // depth: 1: 하나의 토큰을 정규식으로 검증하고 멤버 변수 numbers에 추가
    private void validateAndAddNumber(String token) {
        // 정규표현식 검증을 통과했으므로 안전하게 변환
        int number = Integer.parseInt(token); // depth: 2
        this.numbers.add(number);
    }

    // --- Getter 메서드 (Application에서 파싱 결과를 가져가도록 제공) ---

    // depth: 1
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // depth: 1
    public String getOperatorSymbol() {
        return this.operatorSymbol;
    }
}