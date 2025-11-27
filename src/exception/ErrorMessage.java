package exception;

public enum ErrorMessage {
    INPUT_NULL("입력값이 null 입니다."),
    INPUT_EMPTY("입력값이 비어있습니다."),
    INVALID_SEPARATOR("유효하지 않은 구분자입니다."),
    INVALID_OPERATE("유효하지 않은 사칙연산자입니다."),
    DIVIDE_NOT_ZERO("0으로 나눌 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}