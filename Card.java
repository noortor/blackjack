public class Card 
{
    private int value;
    private String suit;
    private String rank;
    public Card(int vl, String st, String rk)
    {
        // initialise instance variables
        value = vl;
        suit = st;
        rank = rk;
    }
    //returns card value
    public int getValue(){
        return value;
    }
    //sets new value of card, used for aces
    public void setValue(int vl){
        value = vl;
    }

    //returns card suit
    public String getSuit(){
        return suit;
    }
    //returns card rank
    public String getRank(){
        return rank;
    }
    //gives info on card
    public String toString(){
        return rank + " of "+ suit;
    }
}
