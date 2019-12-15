/**
 * 3/10/2019
 *
 * This class is used to create a object Card which is a card that contains suit value and isFaceUp.
 * In the class you can set and get, as well as checking if card is face up or if its red.
 *
 * @author Winston Gong
 * @see CardStack
 * @see Stackotaire
 */
public class Card {
    public static void main(String[] args){

    }

    int suit;
    int value;
    boolean isFaceUp;

    /**
     * This is the constructor for the class with no parameters.
     */
    public Card(){

    }

    /**
     * This is the constructor but with parameters.
     * @param s
     * @param v
     * @param f
     */
    public Card(int s, int v, boolean f ){

        suit = s;
        value = v;
        isFaceUp = f;
    }

    /**
     * gets the suit of the card.
     * @return
     */
    public int getSuit() {
        return suit;
    }

    /**
     * sets the suit of the card.
     * @param suit
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    /**
     * gets the value of the card.
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * sets the value of the card.
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * check if the card is face up
     * @return true of face up false otherwise.
     */
    public boolean isFaceUp(){
        if(isFaceUp){
            return true;
        }
        else return false;
    }

    /**
     * sets the card to be face up.
     */
    public void setFaceUp(){
        isFaceUp = true;
    }

    /**
     * checks whether the suit of the card is red or not, even for red odd for black.
     * @return
     */
    public boolean isRed(){
        if(suit % 2 == 0){
            return true;
        }
        else return false;
    }

    /**
     * returns the card in a formatted string.
     * @return
     */
    public String toString(){

        String values[] = {" ","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        char suits[]    = {' ', '\u2666', '\u2663','\u2665', '\u2660'};   // {' ', '♦', '♣','♥', '♠'}

        String toString = "[" + values[value]+suits[suit] +"]";  // print a card

        return toString;
    }
}
