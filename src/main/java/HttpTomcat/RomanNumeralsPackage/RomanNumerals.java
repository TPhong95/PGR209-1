package HttpTomcat.RomanNumeralsPackage;

public class RomanNumerals {

    public String convertRomanNumerals(int numberToConvert) {

        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] romanNumbers = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

        StringBuilder numberString = new StringBuilder();

        for (int i = values.length-1 ; i >= 0; i--) {
            while(numberToConvert >= values[i]) {
                numberToConvert -= values[i];
                numberString.append(romanNumbers[i]);
            }
        }
        return numberString.toString();

        //Old Roman numerals solution
        /*
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
         */
    }
}
