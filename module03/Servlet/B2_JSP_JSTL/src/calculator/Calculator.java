package calculator;

public class Calculator {
    public static double calculate(double firstNumber, double secondNumber, char operator){
        switch (operator){
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if(secondNumber != 0){
                    return firstNumber/secondNumber;
                }else {
                    throw new RuntimeException("Can't dive zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
