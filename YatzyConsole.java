/*
 * Yatzy.java
 *
 * Created on 25 January 2006, 11:43
 *
 * In Yatzy you roll 5 dice up to 3 times and you try to get the following
 * results:
 *
 * three of a kind (2 dice of the same kind) score: sum of all the dice
 * four of a kind (3 dice of the same kind) score: sum of all the dice
 * full house (2 of one kind, 3 of another) score: yahtzee 25 points
 * small straight (4 consecutive numbers) score: 30 points
 * straight (5 consecutive numbers) score: 40 points
 * Yatzy (5 dice of the same kind) score: 50 points
 * Chance (any combination) score: sum of all the dice
 *
 */

import java.util.*;
public class YatzyConsole {

    static ArrayList<Dice> die = new ArrayList<Dice>();
    static Scanner sc = new Scanner(System.in);
    static int rolls = 3;
    static int numberOfDice, theDice;
    static int playersScore;
    static CombinationCalculator comcal = new CombinationCalculator();
    static Integer[] scorecard = new Integer[15];

    private static Scanner scanner = new Scanner(System.in);

    private static Dice[] dices = new Dice[5];




    public static void main(String [] args) {

        int round = 1;

        while (round <= 15){


            // Throw the dices and show them.
            for (int j =0;j<5;j++) {
                dices[j] = new Dice();
                dices[j].roll();
            }
            System.out.println(printdices());

            // Let the user re-roll the dices.


            int reRolls = 2;
            while (reRolls > 0) {
                System.out.println("Enter the indexes of the dices you "
                        + " want to re-roll: ");
                //System.out.println(" ");
                String reRollDicesStr = scanner.nextLine().trim();

                // Brake if the user just press enter.
                if (reRollDicesStr.length() < 1) {
                    break;
                }

                // Slip the string with the dice numbers to re-roll.
                String[] reRollDices = reRollDicesStr.split(" ");

                for (int i = 0; i < reRollDices.length; i++) {
                    int dieNumber = Integer.parseInt(reRollDices[i]) - 1;

                    try {
                        dices[dieNumber].roll();
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("The die with index " + dieNumber
                                + " does not exists.");

                    }
                }

                //System.out.println(dices.toString());
                String output="";
                for (int i = 0; i < dices.length; i++) {
                    output += "|" + dices[i].getFaceValue() + "|\t";
                }
                System.out.println(output);

                reRolls--;
            }

            // Let the user choose what rule to add the points to.
            while (!chooseRule());

            System.out.println(printdices());
            round++;



        }

        System.out.println("");

        System.out.println("Player got " + playersScore + " points.");

        scanner.close();




/*
        Scanner reader = new Scanner(System.in);

        //this._keepers.clear();
        //this._diceInPlay =
                //new ArrayList<Dice>(Arrays.asList(this._gameDice));

        // Used to control a loop that would ask the user to
        // re enter information if it's invalid.
        boolean validResponse = false;
        boolean validIndex = false;
        boolean rollAgain = false;
        // Variables to store the user input
        //String userInput;
        int userIndex = 0;

        for(int rollCount = 0; rollCount < 3; rollCount ++){
            // roll the dice and let the user do what they need to
            // do with the dice


            System.out.println("A dice is rolled...");

            // Do they want to roll again or hold?
            // Checks for valid response
            rollAgain = rollAndDecide(rollCount);

            if(rollAgain == false){
                rollCount = 3;
            }
        }


        //card.drawScoreCard();

        //printDice(this._keepers,"Here is your hand:");

        // Automatically checks for a bonus yahtzee. If it returns false
        // the program continues to do regular scoring.
        validIndex =
                card.scoreBonusYahtzee(_keepers.toArray(new Dice[0]));


        // Get the user to enter a valid index that is not filled already
        while(validIndex == false){
            validResponse = false;

            try{


                while(validResponse == false){
                    System.out.println("Where would you like"
                            + " to score your dice? (1-13)");

                    userIndex = Integer.parseInt(reader.nextLine());

                    // Has to be between 1-13
                    if(userIndex > 13 || userIndex < 0){

                        System.err.println("Invalid Index");

                    }else{

                        validResponse = true;

                    }

                }

                // Submit the dice and the index to be scored on the
                // score card.
                validIndex = card.submitDice(
                        this._keepers.toArray(new Dice[0]), userIndex);

            }catch(NumberFormatException errorHandler){

                System.err.println("Invalid index. Please try again.");

            }
        }

        // Update the new scores and then show it back to the user.
        card.updateTotals();
        card.drawScoreCard();

*/

        /*
        //Make Dice
        createDice();

        //Roll all dice
        rollDice();

        diceInfo();

        //TO DO make it so person can chose different dice to roll on 3 occasions
        for (int i = 0; i < rolls; i++) {
            System.out.println("Please choose how many dice you would like to reRoll: ");
            try {
                numberOfDice = sc.nextInt();
            } catch (NumberFormatException e) {
                //error message
                System.exit(0);
            }

            //if no dice need to be changed just break the loop
            if (numberOfDice > 5) {
                System.out.println("You have chosen to many dice");
                break;
            }
            if (numberOfDice == 0)break;
            if (numberOfDice <= 5){

                rollDice();
                diceInfo();
            } else {
                for (int j = 0; j < numberOfDice; j++){
                    System.out.println("Please choose dice to reRoll: ");
                    try {
                        theDice = sc.nextInt();
                    } catch (NumberFormatException e) {
                        //error Message
                        System.exit(0);
                    }
                    if (theDice <= 5)
                        reRoll(theDice);
                    else {
                        System.out.println("You have chosen an incorrect dice");
                        break;
                    }

                }
                diceInfo();
            }
        }

         */
    }


    private static String printdices() {
        String output = "\t\t";
/*
        for (int i = 0; i < dices.length; i++) {
            output += " _ \t";
        }
*/
        output += "\nDice value:\t";

        for (int i = 0; i < dices.length; i++) {
            output += "|" + dices[i].getFaceValue() + "|\t";
        }

        output += "\n\t\t";

        for (int i = 0; i < dices.length; i++) {
            output += " ¯ \t";
        }

        output += "\nDice index:\t";

        for (int i = 0; i < dices.length; i++) {
            output += " " + (i + 1) + "\t";
        }

        return output + "\n";
    }


    /**
     * Handle re-rolls.
     */
    public static void reRoll() {
        int reRolls = 2;
        while (reRolls > 0) {
            System.out.print("Enter the numbers of the dices you "
                    + " want to re-roll:");
            String reRollDicesStr = scanner.nextLine().trim();

            // Brake if the user just press enter.
            if (reRollDicesStr.length() < 1) {
                break;
            }

            // Slip the string with the dice numbers to re-roll.
            String[] reRollDices = reRollDicesStr.split(" ");

            for (int i = 0; i < reRollDices.length; i++) {
                int dieNumber = Integer.parseInt(reRollDices[i]) - 1;

                try {
                    dices[dieNumber].roll();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The die with index " + dieNumber
                            + " does not exists.");
                }
            }

            //System.out.println(dices.toString());
            String output="";
            for (int i = 0; i < dices.length; i++) {
                output += "|" + dices[i].getFaceValue() + "|\t";
            }
            System.out.println(output);

            reRolls--;
        }
    }

    /**
     * Let the user choose what rule to add points to.
     * @return True on success, else false.
     */
    public static boolean chooseRule() {
        try {
            System.out.println(choices());
            System.out.println("Choose what combination to use:");

            String choice = scanner.nextLine();

            int intChoice;

            // Check the input, if it fails to parse it as an int, return false.
            try {
                intChoice = Integer.parseInt(choice) - 1;
            }
            catch (NumberFormatException e) {
                System.out.println("That is not a valid rule.");
                return false;
            }

            switch (intChoice) {
                case 0:
                    scorecard[intChoice] = comcal.checkMatches(dices,1);
                    //activePlayer.setPoint(intChoice, Rules.ones());
                    break;
                case 1:
                    scorecard[intChoice] = comcal.checkMatches(dices,2);
                    break;
                case 2:
                    scorecard[intChoice] = comcal.checkMatches(dices,3);
                    break;
                case 3:
                    scorecard[intChoice] = comcal.checkMatches(dices,4);
                    break;
                case 4:
                    scorecard[intChoice] = comcal.checkMatches(dices,5);
                    break;
                case 5:
                    scorecard[intChoice] = comcal.checkMatches(dices,6);
                    break;
                case 6:
                    scorecard[intChoice] = comcal.checkOnePair(dices);
                    break;
                case 7:
                    scorecard[intChoice] = comcal.checkTwoPair(dices);
                    break;
                case 8:
                    scorecard[intChoice] = comcal.check3Kind(dices);
                    break;
                case 9:
                    scorecard[intChoice] = comcal.check4Kind(dices);
                    break;
                case 10:
                    scorecard[intChoice] = comcal.checkSmallStraight(dices);
                    break;
                case 11:
                    scorecard[intChoice] = comcal.checkLargeStraight(dices);
                    break;
                case 12:
                    scorecard[intChoice] = comcal.checkFullHouse(dices);
                    break;
                case 13:
                    scorecard[intChoice] = comcal.checkChance(dices);
                    break;
                case 14:
                    scorecard[intChoice] = comcal.checkYatzy(dices);
                    break;
                default:
                    System.out.println("That is not a valid rule.");
                    return false;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public static String choices() {
        String grid = "";

        String[] choices = { "Aces", "Twos", "Threes", "Fours", "Fives",
                "Sixes", "One pair", "Two pair", "Three of kind",
                "Four of kind", "Small straight", "Large straight",
                "Full house", "Chance", "Yatzy" };

        int[] points = { comcal.checkMatches(dices,1), comcal.checkMatches(dices,2),
                comcal.checkMatches(dices,3), comcal.checkMatches(dices,4),
                comcal.checkMatches(dices,5), comcal.checkMatches(dices,6),
                comcal.checkOnePair(dices), comcal.checkTwoPair(dices), comcal.check3Kind(dices),
                comcal.check4Kind(dices),comcal.checkSmallStraight(dices), comcal.checkLargeStraight(dices),
                comcal.checkFullHouse(dices),comcal.checkChance(dices),comcal.checkYatzy(dices) };

        for (int i = 0; i < choices.length; i++) {
            if (scorecard[i] == null) {
                grid += (i + 1) + "\t add " + points[i] + " points to "
                        + choices[i] + "\n";
            }
        }

        return grid;
    }
    /*
    private static void createDice() {

        Dice die1 = new Dice();
        die.add(die1);

        Dice die2 = new Dice();
        die.add(die2);

        Dice die3 = new Dice();
        die.add(die3);

        Dice die4 = new Dice();
        die.add(die4);

        Dice die5 = new Dice();
        die.add(die5);


    }

    //Method rolls all the dice
    private static void rollDice() {
        die.get(0).roll();
        die.get(1).roll();
        die.get(2).roll();
        die.get(3).roll();
        die.get(4).roll();
    }

    private static void reRoll(int index) {
        die.get(index-1).roll();
    }

    private static void diceInfo() {
        //Display Dice Values
        for (int i = 0; i < die.size(); i++)
            System.out.println("Dice " + (i+1) + ": " + diceValues(die.get(i)));

        //Quick Check Score?
        System.out.println(theScore.getHand(die) + "\n" + "Score: " + theScore.getScore());
    }

    private static int diceValues(Dice d) {
        return d.getFaceValue();
    }
*/
}