package parser;

public class Parser {

    
    // 입력 문자열을 숫자배열과 연산자로 분리하는 메서드
    public ParseResult parse(String input) {
        // 입력 값이 null이거나 공백만 있는 경우 예외 처리
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }

        // 입력의 앞뒤 공백 제거
        input = input.trim();

        // 공백 기준으로 나누어 토큰화 (마지막이 연산자임을 가정)
        String[] tokens = input.split(" ");

        // 최소 2개 이상 토큰이 있어야 함 (숫자 + 연산자)
        if (tokens.length < 2) {
            throw new IllegalArgumentException("연산자가 포함되어야 합니다.");
        }

        // 마지막 토큰이 연산자인지 검사 (+, -, *, / 중 하나여야 함)
        String operator = tokens[tokens.length - 1];
        if (!operator.matches("[+\\-*/]")) {
            throw new IllegalArgumentException("잘못된 연산자입니다: " + operator);
        }

        // 숫자 부분만 다시 문자열로 합침 (중간에 공백 있을 경우 대비)
        String numbersRaw = String.join("", java.util.Arrays.copyOf(tokens, tokens.length - 1));

        // 숫자들을 콤마(,)나 콜론(:) 기준으로 분리
        String[] numberStrings = numbersRaw.split("[,:]");

        // 분리된 문자열 배열을 int 배열로 변환함
        int[] numbers = new int[numberStrings.length];
        try {
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }
        } catch (NumberFormatException e) {
            // 숫자가 아닌 값이 포함되면 예외 발생
            throw new IllegalArgumentException("숫자 변환 오류: " + e.getMessage());
        }

        // 숫자 배열과 연산자를 포함하는 ParseResult 객체 생성 및 반환
        return new ParseResult(numbers, operator);
    }

    /**
     * 숫자 배열과 연산자를 담는 내부 정적 클래스
     */
    public static class ParseResult {
        public final int[] numbers;    // 입력된 숫자 배열
        public final String operator;  // 입력된 연산자

        /**
         * 생성자: 각 필드를 초기화
         * @param numbers 숫자 배열
         * @param operator 연산자 문자열
         */
        public ParseResult(int[] numbers, String operator) {
            this.numbers = numbers;
            this.operator = operator;
        }
    }
}
