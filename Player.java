import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
    Scanner scan = new Scanner(System.in);
    //player hand
    ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int totalValue = 0;
    private double money;
    private boolean choiceStay = false;
    public Player(String nm, double mon)
    {
        // initialise instance variables
        name = nm;
        money = mon;
    }
    //places bet based on user input
    public double bet(){
        //holds money to be bet
        System.out.println("How much would you like to bet");
        double holder = scan.nextInt();
        money -= holder;
        return holder;
    }
    //hits
    public void hit(Card newCard){
        addCard(newCard);
    }
    //adds a new card and updates value
    public void addCard(Card newCard){
        hand.add(newCard);
        totalValue = handTotal();
    }
    // //sums up all card values and returns it
    public int handTotal(){
        int sum = 0;
        for(int i=0;i<hand.size();i++){
            sum += hand.get(i).getValue();
        }
        if(sum>21){
            for(int i=0;i<hand.size();i++){
                if(hand.get(i).getValue()==11){
                    hand.get(i).setValue(1);
                }
            }
        }
        return sum;
    }
    
    //gives hand total
    public String toString(){
        return "The hand total is " + totalValue;
    }
    public void stay(){
        choiceStay = true;        
    }
    public boolean getChoiceStay(){
        return choiceStay;
    }
    
    //changes amt of money
    public void setMoney(double mn){
        money+=mn;
    }
    //returns amt of money
    public double getMoney(){
        return money;
    }
    //returns total value
    public int getTotalValue(){
        return totalValue;
    }
}
