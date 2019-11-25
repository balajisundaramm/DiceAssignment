import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceManager {

    public static void main(String[] args) {
        /**
         * Scanner to get input from user
         */
        Scanner sc1 = new Scanner(System.in);
        int noOfDies = getNoOfDices();
        System.out.println("Total number of dices " + noOfDies);

        List<Dice> dices = new ArrayList<>();
        // Collecting all dices to the dices list
        for(int i=0; i<noOfDies; i++) {
            dices.add(getDice());
        }

        String arithmeticRelationship = "";
        List<String> operators = new ArrayList<>();
        // Getting arithmetic relationships between the dices from user and collecting it operators list.
        for(int i=0; i<dices.size()-1; i++){
            System.out.println("Please enter the arithmetic relationship between " + dices.get(i) + " and " + dices.get(i+1)+ "dice");
            arithmeticRelationship = sc1.nextLine();
            boolean flag = true;
            while(flag) {
                if(!arithmeticRelationship.equals("+") && !arithmeticRelationship.equals("-")){
                    flag = false;
                    i--;
                    sc1 = new Scanner(System.in);
                    System.out.println("Please enter + or -");
                } else {
                    flag = false;
                    operators.add(arithmeticRelationship);
                }

            }

        }

        // Printing the dices and relationships between them
        for(int i=1; i<=dices.size(); i++) {
            System.out.print(dices.get(i-1) + " ");
            if(i <= operators.size()) {
                System.out.print(operators.get(i-1) + " ");
            }
        }
        System.out.println();
        Dice totalDice = new Dice();
        totalDice.setMin(totalDice.getMin()+dices.get(0).getMin());
        totalDice.setMax(totalDice.getMax()+dices.get(0).getMax());
        // Calculating the minimum possibilities and maximum possibilities
        for(int i=1; i<dices.size(); i++) {
            if(i!=dices.size() && operators.get(i-1).equals("+")) {
                totalDice.setMin(totalDice.getMin() + dices.get(i).getMin());
                totalDice.setMax(totalDice.getMax() + dices.get(i).getMax());
            }
            if(i!=dices.size() && operators.get(i-1).equals("-")) {
                totalDice.setMin(totalDice.getMin() - dices.get(i).getMin());
                totalDice.setMax(totalDice.getMax() - dices.get(i).getMax());
            }

        }

        System.out.println("Minimum Possibilities - " + totalDice.getMin());
        System.out.println("Maximum Possibilities - " + totalDice.getMax());
    }

    /**
     * This method is used to generate dice
     * @return
     */
    public static Dice getDice() {
        int number = 0;
        while (number !=8 && number !=4 && number !=6 && number !=10 && number !=12 && number !=20){
            double v = Math.random();
            v = v * 100;
            number = (int) v;
        }
        double count = Math.random();
        count = count * 100;
        int noOfTimesTobeRolled = (int) count;
        String result = noOfTimesTobeRolled + "D" + number;
        Dice dice = new Dice();
        dice.setDice(result);
        dice.setMin(noOfTimesTobeRolled);
        dice.setMax(noOfTimesTobeRolled * number);
        return dice;
    }

    /**
     * This method will return total number of dices to be rolled
     * @return
     */
    public static int getNoOfDices() {
        double count = Math.random();
        count = (count * 10) / 2;
        int result = (int) count;
        return  (result != 0 && result != 1) ? result : getNoOfDices();
    }
}
