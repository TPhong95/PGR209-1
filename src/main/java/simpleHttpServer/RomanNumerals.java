package simpleHttpServer;

public class RomanNumerals {

    public String convertRomanNumerals(int numberToConvert) {
        RomanNumberObject answer = new RomanNumberObject(numberToConvert);

        answer = digitConverter(100, "C", answer);
        answer = digitConverter(99, "IC", answer);
        answer = digitConverter(90, "XC", answer);
        answer = digitConverter(89, "IXC", answer);
        answer = digitConverter(50, "L",  answer);
        answer = digitConverter(49, "IL", answer);
        answer = digitConverter(10, "X", answer);
        answer = digitConverter(9, "IX", answer);
        answer = digitConverter(5, "V", answer);
        answer = digitConverter(4, "IV", answer);
        answer = digitConverter(1, "I", answer);
        return answer.getRomanNumberStringAnswer();
    }

    public RomanNumberObject digitConverter(int digit, String romanNumber, RomanNumberObject answer) {
        var numberToCalc = answer.getNumberLeftToCalculate();
        var newAnswer = answer.getRomanNumberStringAnswer();
        while (numberToCalc >= digit) {
            answer.setNumberLeftToCalculate(numberToCalc -= digit);
            answer.setRomanNumberStringAnswer(newAnswer + romanNumber);
        }
        return answer;
    }


}
