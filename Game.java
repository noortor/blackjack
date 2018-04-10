import java.util.Scanner;
public class Game
{
    //array of player and dealer
    Player[] players = new Player[]{new Player("Player 1", 100),new Player("Dealer", -1)};
    Scanner scan = new Scanner(System.in);
    //new deck
    Deck gameDeck = new Deck();
    //checks if game should continue
    private boolean gameOn = false;
    //checks if player won
    private boolean playerWin;
    //holds bet
    private double moneyOnHold;
    public Game(){
    }
    //starts game
    public void startGame(){
        gameOn = true;
        //gives cards to player
        for(int i = 0; i<2;i++){
            players[0].addCard(gameDeck.deal());
        }
        //gives cards to dealer
        for(int i = 0; i<2;i++){
            players[1].addCard(gameDeck.deal());
        }
        //gets bet
        moneyOnHold = players[0].bet();
        //begins first turn
        turn();
    }
    public void turn(){
        while (gameOn){       
            //determines who hits/stays based on player input and values
            while(players[0].getChoiceStay()==false&& gameOn){
                if(players[0].getTotalValue()<=21){
                    giveInfo();
                    System.out.println("Would you like to hit or stay?");
                    String response = scan.next();
                    if (response.equals("hit")){
                        players[0].hit(gameDeck.deal());
                        System.out.println("You hit");
                        
                    }
                    else{
                        players[0].stay();
                        System.out.println("You stayed");
                        
                    }
                }           
                else{
                    //game ends when player stays or has a value over 21
                    gameOn = false;              
                }
            }
            if(gameOn){
                if (players[1].getTotalValue() >=17){
                    players[1].stay();
                    System.out.println("The dealer stayed");
                    gameOn=false;
                }
                else{
                    players[1].hit(gameDeck.deal());
                    System.out.println("The dealer hit");
                }
            }
        }
        giveInfo();
        determineWinner();
        endGame();
    }
    //gives player info on cards and values
    public void giveInfo(){
       for(int i = 0; i<players[0].hand.size();i++){
                System.out.println("You have a " + players[0].hand.get(i));
       }
       System.out.println(players[0]);
       //System.out.println(players[1]);
       System.out.println("The dealer has a " + players[1].hand.get(1));
    }
    //uses values to determine winner
    public void determineWinner(){
        //player wins if value is 21 or less and greater than dealer
        if((players[0].getTotalValue()<=21 && players[0].getTotalValue()>players[1].getTotalValue())||players[1].getTotalValue()>21){
            playerWin = true;
        }
        else{
            playerWin = false;
        }
    }
    //handles bet and prints winner and money
    public void endGame(){
        if (playerWin){
            System.out.println("You win");
            players[0].setMoney(2*moneyOnHold);
        }
        else{
            System.out.println("The house wins");
        }
        System.out.println("You have $ "+ players[0].getMoney());
    }
}
