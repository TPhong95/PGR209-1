package simpleHttpServer;

public class RomanNumberObject {
    private String romanNumberStringAnswer;
    private int numberLeftToCalculate;

    public RomanNumberObject(int numberLeftToCalculate) {
        this.romanNumberStringAnswer = "";
        this.numberLeftToCalculate = numberLeftToCalculate;
    }

    public String getRomanNumberStringAnswer() {
        return romanNumberStringAnswer;
    }

    public void setRomanNumberStringAnswer(String romanNumberStringAnswer) {
        this.romanNumberStringAnswer = romanNumberStringAnswer;
    }

    public int getNumberLeftToCalculate() {
        return numberLeftToCalculate;
    }

    public void setNumberLeftToCalculate(int numberLeftToCalculate) {
        this.numberLeftToCalculate = numberLeftToCalculate;
    }
}


