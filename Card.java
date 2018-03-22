
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
    public int getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
}
