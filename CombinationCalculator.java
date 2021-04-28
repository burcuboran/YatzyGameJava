import java.util.ArrayList;
import java.util.Collections;

public class CombinationCalculator {

	private int v;

	public CombinationCalculator(){

	}

	public int checkMatches(Dice[] d, int MatchVal){ // this checks the faceValues of the dice, to see if there are any 1's
		int total = 0;

		for (int i = 0; i < d.length; i++){

			if (d[i].getFaceValue() == MatchVal){
				total += 1;					// adds 1 on to the total. This loop runs every roll, and so this needs to be re-added every roll even if dice held.
			}
		}
		return total * MatchVal; // sets the score


	}

	public int checkOnePair(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		int dice0 = dice.get(0);
		int dice1 = dice.get(1);
		int dice2 = dice.get(2);
		int dice3 = dice.get(3);
		int dice4 = dice.get(4);


		if (dice4 == dice3) return dice4 * 2;
		if (dice3 == dice2) return dice3 * 2;
		if (dice2 == dice1) return dice2 * 2;
		if (dice1 == dice0) return dice1 * 2;
		return 0;
	}

	public int checkTwoPair(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		int dice0 = dice.get(0);
		int dice1 = dice.get(1);
		int dice2 = dice.get(2);
		int dice3 = dice.get(3);
		int dice4 = dice.get(4);

		// Fill the counter of each number
		int[] cnt = new int[6];
		for(int k = 0; k < 5; k++){
			cnt[dice.get(k)-1]++;
		}

		int firstpair = 0;
		int secondpair = 0;

		// check for two pairs
		for(int k = 5; k >=0; k--){
			if (cnt[k]>1){
				if (firstpair==0) {firstpair=k+1;} else {secondpair=k+1;}
			}
		}
		if (firstpair>0 && secondpair>0){
			return (firstpair + secondpair) * 2;
		}
		return 0;
	}

	public int check3Kind(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		int dice0 = dice.get(0);
		int dice1 = dice.get(1);
		int dice2 = dice.get(2);
		int dice3 = dice.get(3);
		int dice4 = dice.get(4);

		if ( (dice0 == dice1 && dice0 == dice2) || (dice1 == dice2 && dice1 == dice3) || (dice2 == dice3 && dice2 == dice4)){
			return dice2 * 3;
		} else {
			return 0;
		}
	}

	public int check4Kind(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		int dice0 = dice.get(0);
		int dice1 = dice.get(1);
		int dice2 = dice.get(2);
		int dice3 = dice.get(3);
		int dice4 = dice.get(4);


		if ( (dice0 == dice1 && dice0 == dice2 && dice0 == dice3) ||
				(dice1 == dice2 && dice1 == dice3 && dice1 == dice4)
		){
			return dice2 * 4;
		} else {
			return 0;
		}
	}

	public int checkFullHouse(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		int dice0 = dice.get(0);
		int dice1 = dice.get(1);
		int dice2 = dice.get(2);
		int dice3 = dice.get(3);
		int dice4 = dice.get(4);

		int score = dice0 + dice1 + dice2 + dice3 + dice4;

		if ( (dice0 == dice1 && dice0 == dice2 && dice3 == dice4) ||
				(dice0 == dice1 && dice2 == dice3 && dice2 == dice4) ) {
			return score;
		} else {
			return 0;
		}
	}

	public int checkSmallStraight(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		int[] dnw = new int[5]; // this is a new array to pass the Integers through and make into int.
		int score = 30;

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		for (int i = 0; i < d.length ; i++ ){
			if (dice.get(i) != i + 1 ) return 0;
		}

		return 15;
	}

	public int checkLargeStraight(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		int[] dnw = new int[5]; // this is a new array to pass the Integers through and make into int.
		int score = 30;

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		Collections.sort(dice);

		for (int i = 0; i < d.length ; i++ ){
			if (dice.get(i) != i +2 ) return 0;
		}

		return 20;
	}


	public int checkYatzy(Dice[] d){
		ArrayList<Integer> dice = new ArrayList<Integer>();

		for (int i = 0; i < d.length ; i++ ){
			dice.add(d[i].getFaceValue());
		}

		for (int i = 0; i < d.length -1 ; i++ ){
			if (dice.get(i) != dice.get(i+1) ) return 0;
		}

		return 50;
	}

	public int checkChance(Dice[] d){

		int dice0 = d[0].getFaceValue();
		int dice1 = d[1].getFaceValue();
		int dice2 = d[2].getFaceValue();
		int dice3 = d[3].getFaceValue();
		int dice4 = d[4].getFaceValue();

		return dice0 + dice1 + dice2 + dice3 + dice4;

	}

}
