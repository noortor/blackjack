import java.util.ArrayList;
import java.util.Random;
public class Deck
{
    //original deck
    ArrayList <Card> deck = new ArrayList<Card>();
    //new deck
    Card[] shuffledDeck = new Card[52];
    //suits
    String nameArray[] =  {"Hearts","Spades","Clubs","Diamonds"};
    //keeps track of where we are in the deck when distributing cards
    int index = -1;
    public Deck()
    {
        fillDeck(); 
        shuffle();
    }
    public void fillDeck(){
        //initializes number cards
        for(String nm: nameArray){
            for(int i=2; i < 11; i++){
                deck.add(new Card(i, nm, Integer.toString(i)));
            }
            //initializes face cards
            deck.add(new Card(10, nm, "Jack"));
            deck.add(new Card(10, nm, "Queen"));
            deck.add(new Card(10, nm, "King"));
            deck.add(new Card(11, nm, "Ace"));
        }       
    }
    //shuffles deck
    public void shuffle(){
        //copies deck
        for (int i = 0; i< 52; i++){
            shuffledDeck[i] = deck.get(i);
        }
        Random random = new Random();
        //swaps each card with a random one in the rest of the deck
        for(int i = 0; i<52; i++){
            int swapIndex = i + random.nextInt(52-i);
            Card holder = shuffledDeck[i];
            shuffledDeck[i] = shuffledDeck[swapIndex];
            shuffledDeck[swapIndex] = holder;
        }
    }

    
    //deals cards
    public Card deal(){
        index++;
        return shuffledDeck[index];
    }
}
