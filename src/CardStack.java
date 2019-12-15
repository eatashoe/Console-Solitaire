/**
 * 3/10/2019
 *
 * This class is used to create a CardStack which is a stack of Cards that has 4 different types.
 * In the class you can push, pop, check if its empty, check the size, and printStack.
 *
 * @author Winston Gong
 * @see Card
 * @see Stackotaire
 */
import java.util.Stack;

public class CardStack extends Stack<Object> {

    public static void main(String[] args){

    }

    char type;
    Stack<Card> cardStack;

    /**
     * This is the constructor for the CardStack which takes a type and creates a stack of Cards.
     * @param t
     */
    public CardStack(char t){
        type = t;
        cardStack = new Stack<Card>();
    }


    /**
     * This adds a Card on top of the stack.
     * @param newCard
     */
    public void push(Card newCard){
        cardStack.push(newCard);
    }

    /**
     * This removes the Card at the top of the stack.
     * @return
     */
    public Card pop(){
        return cardStack.pop();
    }

    /**
     * This checks if the stack is empty.
     * @return
     */
    public boolean isEmpty(){
        return empty();
    }

    /**
     * This finds the size of the stack.
     * @return
     */
    public int size(){
        return cardStack.size();
    }

    /**
     * This prints the stack in a formatted string depending on the type of stack it is.
     * @param type
     */
    public void printStack(char type){
        switch(type){
            case ('s'):
                if(this.isEmpty()){
                    System.out.print("[  ]");
                }
                else {
                    System.out.print("[XX]");
                }
                break;
            case ('w'):
                if(this.isEmpty()){
                    System.out.print("[  ]");
                }
                else {
                    System.out.print(cardStack.peek().toString());
                }
                break;
            case ('f'):
                System.out.print(cardStack.peek().toString());
                break;
            case ('t'):
                for(int x = 0; x < this.size(); x++){
                    String toString = "";

                    if(cardStack.elementAt(x).isFaceUp) {
                        toString += cardStack.elementAt(x).toString();
                    }
                    else{
                        toString += "[XX]";
                    }

                    if(this.isEmpty()){
                        toString = "[  ]";
                    }

                    System.out.print(toString);
                }
                break;

        }
    }
}
