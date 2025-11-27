import input.Input;
import output.Output;
import parser.Parser;
import calculator.Calculator;

public class Main {

    public static void main(String[] args) {
        String userInput = Input.nextLine();
        Parser parser = new Parser();
        parser.parse(userInput);
        Calculator calculator = new Calculator();
        calculator.calculate(parser.getNumbers(), parser.getOperatorSymbol())
        Output output = new Output();
    }
}
