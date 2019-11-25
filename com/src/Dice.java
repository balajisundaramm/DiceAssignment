public class Dice {
    private String Dice;
    private int min;
    private int max;

    public String getDice() {
        return Dice;
    }

    public void setDice(String dice) {
        Dice = dice;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return
                "Dice='" + Dice + '\'';
    }
}
