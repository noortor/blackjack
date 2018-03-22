
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Player
{
    ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int totalValue = 0;
    private double money;
    public Player(String nm, double mon)
    {
        // initialise instance variables
        name = nm;
        money = mon;
    }

}
