import java.util.Random;

public class Dice {

    private int faceValue;
    private boolean isfixed = false;

    /**
     * Selects a random value between 1-6, simulating a dice.
     */
    public void roll(){
        Random rand = new Random();
        faceValue = rand.nextInt(6) + 1;
    }

    /**
     * Gets a boolean value whether the dice is hold or not
     */
    public boolean getfixed(){

        return this.isfixed ;
    }

    /**
     * @param holdValue whether the dice is held or not
     */
    public void setfixed(boolean holdValue){
        this.isfixed = holdValue;

    }

    /**
     *
     * @param faceValue the value that the dice is to be set to
     */
    public void setFaceValue(int faceValue){
        this.faceValue = faceValue;
    }

    /**
     * gets the hold state of the dice, returning the boolean.
     *
     * @return if the dice is held
     */
    public boolean getHoldState(){
        return isfixed;
    }

    /**
     *
     * @return the face value of the dice.
     */
    public int getFaceValue(){
        return faceValue;
    }

}
