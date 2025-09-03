package simpleHttpServer;

public class romanNumberObject {
    private String romanNumberStringAnswer;
    private int numberLeftToCalculate;

    public romanNumberObject(int numberLeftToCalculate) {
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


