/**
 * 3/10/2019
 *
 * This class creates a solitaire game using multiple stacks.
 *
 * @author Winston Gong
 * @see Card
 * @see CardStack
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Collections.shuffle;

public class Stackotaire {

    ArrayList<Card> d = new ArrayList<Card>();
    CardStack deck;
    CardStack stock;
    CardStack waste;
    CardStack t1;
    CardStack t2;
    CardStack t3;
    CardStack t4;
    CardStack t5;
    CardStack t6;
    CardStack t7;

    CardStack f1;
    CardStack f2;
    CardStack f3;
    CardStack f4;


    ArrayList<Card> copy = new ArrayList<Card>();

    public static void main(String[] args){

        Stackotaire solitaire = new Stackotaire();

        solitaire.initialize();

        boolean quit = false;


        do {
            Map<String, CardStack> c = new HashMap<>();
            c.put("w1", solitaire.waste);
            c.put("f1", solitaire.f1);
            c.put("f2", solitaire.f2);
            c.put("f3", solitaire.f3);
            c.put("f4", solitaire.f4);

            c.put("t1", solitaire.t1);
            c.put("t2", solitaire.t2);
            c.put("t3", solitaire.t3);
            c.put("t4", solitaire.t4);
            c.put("t5", solitaire.t5);
            c.put("t6", solitaire.t6);
            c.put("t7", solitaire.t7);

            solitaire.render();


            Scanner input = new Scanner(System.in);
            String[] option = input.nextLine().toLowerCase().split(" ");
            String answer = "";

            if(solitaire.winner()){
                System.out.println("\n" +
                        "\n" +
                        "CONGRATULATIONS YOU WON!!!!!!!!" +
                        "\n" +
                        "Do you want to play again? (Y/N): \n");
                answer = input.nextLine();
                if(answer.equals("y")){
                    solitaire.resetBoard();
                    solitaire.initialize();
                }
                else{
                    System.out.println("Game Over");
                    return;
                }
                break;
            }

            switch (option[0]){
                case ("draw"):
                    if(!solitaire.stock.isEmpty()){
                        solitaire.waste.push(solitaire.stock.pop());
                    }
                    else{
                        int s = solitaire.waste.size();
                        for(int x = 0; x < s; x++){

                            solitaire.stock.push(solitaire.waste.pop());

                        }
                        solitaire.waste.push(solitaire.stock.pop());
                    }
                    break;
                case ("move"):



                    if(option[1].equals("w1")){

                        if(solitaire.waste.isEmpty()){
                            System.out.println("There are no cards in W1.");
                        }
                        else if(option[2].substring(0, 1).equals("f")){
                            if(c.get(option[2]).isEmpty()){
                                if(c.get(option[1]).cardStack.peek().value == 1){
                                    c.get(option[2]).push(c.get(option[1]).pop());
                                    c.get(option[2]).cardStack.peek().setFaceUp();
                                }
                                else{
                                    System.out.println("You cannot move this.");
                                }
                            }
                            else if(c.get(option[2]).cardStack.peek().value + 1 == c.get(option[1]).cardStack.peek().value && c.get(option[2]).cardStack.peek().suit == c.get(option[1]).cardStack.peek().suit){

                                c.get(option[2]).push(c.get(option[1]).pop());
                                c.get(option[2]).cardStack.peek().setFaceUp();
                            }
                            else{
                                System.out.println("You cannot move this.");
                            }

                        }
                        else if(option[2].substring(0,1).equals("t")){
                            if(c.get(option[2]).isEmpty()){
                                if(c.get(option[1]).cardStack.peek().value == 13){
                                    c.get(option[2]).push(c.get(option[1]).pop());
                                    c.get(option[2]).cardStack.peek().setFaceUp();
                                }
                                else{
                                    System.out.println("You cannot move this.");
                                }
                            }
                            else if(c.get(option[2]).cardStack.peek().value - 1 == c.get(option[1]).cardStack.peek().value && ((c.get(option[2]).cardStack.peek().isRed())^(c.get(option[1]).cardStack.peek().isRed()))){
                                c.get(option[2]).push(c.get(option[1]).pop());
                                c.get(option[2]).cardStack.peek().setFaceUp();
                            }
                            else{
                                System.out.println("You cannot move this.");
                            }
                        }
                    }
                    else if(option[1].substring(0,1).equals("f")){

                        if(c.get(option[1]).isEmpty()){
                            String name = option[1].toUpperCase();
                            System.out.println("There are no cards in "+ name +".");
                        }
                        else if(option[2].substring(0,1).equals("t")){
                            if(c.get(option[2]).isEmpty()){
                                if(c.get(option[1]).cardStack.peek().value == 13){
                                    c.get(option[2]).push(c.get(option[1]).pop());
                                    c.get(option[2]).cardStack.peek().setFaceUp();
                                }
                                else{
                                    System.out.println("You cannot move this.");
                                }
                            }
                            else if(c.get(option[2]).cardStack.peek().value - 1 == c.get(option[1]).cardStack.peek().value && ((c.get(option[2]).cardStack.peek().isRed())^(c.get(option[1]).cardStack.peek().isRed()))){
                                c.get(option[2]).push(c.get(option[1]).pop());
                                c.get(option[2]).cardStack.peek().setFaceUp();
                            }
                            else{
                                System.out.println("You cannot move this.");
                            }
                        }
                    }
                    else if(option[1].substring(0,1).equals("t")){

                        if(c.get(option[1]).isEmpty()){
                            String name = option[1].toUpperCase();
                            System.out.println("There are no cards in "+ name + ".");
                        }
                        else if(option[2].substring(0,1).equals("f")){
                            if(c.get(option[2]).isEmpty()){
                                if(c.get(option[1]).cardStack.peek().value == 1){
                                    c.get(option[2]).push(c.get(option[1]).pop());
                                    c.get(option[2]).cardStack.peek().setFaceUp();

                                    if(!c.get(option[1]).isEmpty()){
                                        c.get(option[1]).cardStack.peek().setFaceUp();
                                    }
                                }
                                else{
                                    System.out.println("You cannot move this.");
                                }
                            }
                            else if(c.get(option[2]).cardStack.peek().value + 1 == c.get(option[1]).cardStack.peek().value && c.get(option[2]).cardStack.peek().suit == c.get(option[1]).cardStack.peek().suit){

                                c.get(option[2]).push(c.get(option[1]).pop());
                                c.get(option[2]).cardStack.peek().setFaceUp();

                                if(!c.get(option[1]).isEmpty()){
                                    c.get(option[1]).cardStack.peek().setFaceUp();
                                }
                            }
                            else{
                                System.out.println("You cannot move this.");
                            }

                        }
                        else if(option[2].substring(0,1).equals("t")){
                            if(c.get(option[2]).isEmpty()){
                                if(c.get(option[1]).cardStack.peek().value == 13){
                                    c.get(option[2]).push(c.get(option[1]).pop());
                                    c.get(option[2]).cardStack.peek().setFaceUp();

                                    if(!c.get(option[1]).isEmpty()){
                                        c.get(option[1]).cardStack.peek().setFaceUp();
                                    }
                                }
                                else{
                                    System.out.println("You cannot move this.");
                                }
                            }
                            else if(c.get(option[2]).cardStack.peek().value - 1 == c.get(option[1]).cardStack.peek().value && ((c.get(option[2]).cardStack.peek().isRed())^(c.get(option[1]).cardStack.peek().isRed()))){
                                c.get(option[2]).push(c.get(option[1]).pop());
                                c.get(option[2]).cardStack.peek().setFaceUp();

                                if(!c.get(option[1]).isEmpty()){
                                    c.get(option[1]).cardStack.peek().setFaceUp();
                                }

                            }
                            else{
                                System.out.println("You cannot move this.");
                            }
                        }
                    }

                    break;
                case ("moven"):
                    if(c.get(option[1]).isEmpty()){
                        String name = option[1].toUpperCase();
                        System.out.println("There are no cards in "+ name + ".");
                    }
                    else {
                        CardStack temp = new CardStack('t');


                        if (c.get(option[2]).isEmpty()) {

                            if (c.get(option[1]).cardStack.elementAt(c.get(option[1]).cardStack.size() - parseInt(option[3])).value == 13) {

                                for (int x = 0; x < parseInt(option[3]); x++) {
                                    temp.push(c.get(option[1]).pop());
                                }
                                for(int x = 0; x < parseInt(option[3]); x++){
                                    c.get(option[2]).push(temp.pop());
                                }
                                c.get(option[2]).cardStack.peek().setFaceUp();
                                if (!c.get(option[1]).isEmpty()) {
                                    c.get(option[1]).cardStack.peek().setFaceUp();
                                }
                            } else {
                                System.out.println("You cannot move this.");
                            }
                        }
                        else if(c.get(option[2]).cardStack.peek().value - 1 == c.get(option[1]).cardStack.elementAt(c.get(option[1]).cardStack.size() - parseInt(option[3])).value && ((c.get(option[2]).cardStack.peek().isRed())^(c.get(option[1]).cardStack.elementAt(c.get(option[1]).cardStack.size() - parseInt(option[3])).isRed()))){
                            for (int x = 0; x < parseInt(option[3]); x++) {
                                temp.push(c.get(option[1]).pop());
                            }
                            for(int x = 0; x < parseInt(option[3]); x++){
                                c.get(option[2]).push(temp.pop());
                            }

                            c.get(option[2]).cardStack.peek().setFaceUp();
                            if(!c.get(option[1]).isEmpty()){
                                c.get(option[1]).cardStack.peek().setFaceUp();
                            }

                        }
                        else{
                            System.out.println("You cannot move this..");
                        }
                    }
                    break;

                case ("restart"):
                    System.out.println("Do you want to start a new game? (Y/N): ");
                    answer = input.nextLine().toLowerCase();
                    if(answer.equals("y")){
                        System.out.println("Sorry, you lose. Starting new game.\n");

                        solitaire.resetBoard();
                        solitaire.initialize();

                    }
                    break;

                case ("quit"):
                    System.out.println("Do you want to quit? (Y/N): ");
                    answer = input.nextLine().toLowerCase();
                    if(answer.equals("y")){
                        System.out.println(
                                "Sorry, you lose.\n" +
                                "\n" +
                                "\n" +
                                "Program terminating...");
                        quit = true;
                    }
                    else break;
            }

        }while(!quit || solitaire.winner());
    }

    /**
     * Initializes the stacks for the game.
     */
    public void initialize(){

         deck = new CardStack('s');
         d = new ArrayList<Card>();
         stock = new CardStack('s');
         waste = new CardStack('w');
         f1 = new CardStack('f');
         f2 = new CardStack('f');
         f3 = new CardStack('f');
         f4 = new CardStack('f');

         t1 = new CardStack('t');
         t2 = new CardStack('t');
         t3 = new CardStack('t');
         t4 = new CardStack('t');
         t5 = new CardStack('t');
         t6 = new CardStack('t');
         t7 = new CardStack('t');


        for(int x = 1; x <= 4; x++){
            for(int y = 1; y <= 13; y++){
                Card card = new Card(x,y, false);
                d.add(card);
            }
        }

        shuffle(d);

        for(int x = 0; x < d.size(); x++){
            deck.push(d.get(x));
        }

        copy.addAll(deck.cardStack);

        for(int x = 0; x < 24; x++){
            stock.push(deck.pop());

        }
        for(int x = 7; x > 0; x--){
            for(int y = 0; y < x; y++){
                if(x == 7){
                    if(y == 6){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t7.push(deck.pop());
                }
                else if(x == 6){
                    if(y == 5){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t6.push(deck.pop());
                }
                else if(x == 5){
                    if(y == 4){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t5.push(deck.pop());
                }
                else if(x == 4){
                    if(y == 3){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t4.push(deck.pop());
                }
                else if(x == 3) {
                    if(y == 2){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t3.push(deck.pop());
                }
                else if(x == 2) {
                    if(y == 1){
                        deck.cardStack.peek().setFaceUp();
                    }
                    t2.push(deck.pop());
                }
                else{
                    deck.cardStack.peek().setFaceUp();
                    t1.push(deck.pop());
                }

            }
        }

    }

    /**
     * Renders the graphics for the game
     */
    public void render(){
        if(f1.isEmpty()){
            System.out.print("[F1]");
        }
        else {
            f1.printStack(f1.type);
        }
        if(f2.isEmpty()){
            System.out.print("[F2]");
        }
        else {
            f2.printStack(f2.type);
        }
        if(f3.isEmpty()){
            System.out.print("[F3]");
        }
        else {
            f3.printStack(f3.type);
        }
        if(f4.isEmpty()){
            System.out.print("[F4]");
        }
        else {
            f4.printStack(f4.type);
        }
        System.out.print("     W1 ");
        waste.printStack(waste.type);
        System.out.print("    ");
        stock.printStack(stock.type);
        System.out.print(" ");
        System.out.println(stock.size() + "\n");

        System.out.print("T7 ");
        t7.printStack(t7.type);
        System.out.print("\nT6 ");
        t6.printStack(t6.type);
        System.out.print("\nT5 ");
        t5.printStack(t5.type);
        System.out.print("\nT4 ");
        t4.printStack(t4.type);
        System.out.print("\nT3 ");
        t3.printStack(t3.type);
        System.out.print("\nT2 ");
        t2.printStack(t2.type);
        System.out.print("\nT1 ");
        t1.printStack(t1.type);
        System.out.println("\nEnter a command: ");

    }

    /**
     * resets the stacks of the game.
     */
    public void resetBoard(){
        d.clear();
        deck.removeAllElements();
        waste.removeAllElements();
        stock.removeAllElements();
        f1.removeAllElements();
        f2.removeAllElements();
        f3.removeAllElements();
        f4.removeAllElements();
        t1.removeAllElements();
        t2.removeAllElements();
        t3.removeAllElements();
        t4.removeAllElements();
        t5.removeAllElements();
        t6.removeAllElements();
        t7.removeAllElements();
    }

    /**
     * checks if the player has won by checking every card whether it is face up.
     * @return
     */
    public boolean winner(){
        boolean maybe = true;
        for(int x = 0; x < 52; x++){
            if(!copy.get(x).isFaceUp()){
                maybe = false;
            }
        }
        return maybe;
    }
}
