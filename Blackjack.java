import java.util.Scanner;
public class Blackjack
{
    public static void main(){
        boolean playGame = true;
        while(playGame){
            Scanner scan = new Scanner(System.in);
            Game blackjack = new Game();
            blackjack.startGame();
            System.out.println("Continue?");
            String response = scan.next();
            if(response.equals("no")){
                playGame = false;
            }
           
        }
        
    }
}
