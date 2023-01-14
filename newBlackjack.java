import java.util.Scanner;
import java.util.Random;
public class newBlackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int s1 = drawRandomCard();
        int s2 = drawRandomCard();

        System.out.println("\nYou get a \n"+ (cardString(s1)) +"\n and a \n"+ (cardString(s2)));
        int total = (Math.min(s1, 10)+(Math.min(s2,10)));
        System.out.println("Your total is "+total);
        int firstCard = drawRandomCard();
        System.out.println("The dealer shows \n"+ cardString(firstCard)+"\nand has a card facing down \n"+ faceDown());
        System.out.println("\nThe dealer's total is hidden");
        while(true){
            if(hitOrStay().equals("hit")){
                int newC = drawRandomCard();
                newC = Math.min(newC, 10);
                total+=newC;
               
                System.out.println("\nYou get a\n"+cardString(newC));
                System.out.println("Your new total is "+total);
                if(total>21){
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
             
            }else{
                System.out.println("\nDealer's turn");
                int faceUp = drawRandomCard();
                System.out.println("\nThe dealer's cards are \n"+cardString(firstCard)+"\n and a\n"+cardString(faceUp));
                int dealerTotal = (Math.min(faceUp, 10)+(Math.min(firstCard,10)));
                if(dealerTotal>=17){
                    System.out.println("\ndealer's total is "+ dealerTotal);
                }
               
                while(dealerTotal<17){
                    int newDeal=drawRandomCard();
                    System.out.println("\nDealer gets a \n"+ cardString(newDeal));
                    newDeal = Math.min(newDeal, 10);
                    dealerTotal=dealerTotal+=newDeal;
                    System.out.println("\nDealer's total is "+ dealerTotal);
                    if(dealerTotal>21){
                        System.out.println("Bust! Dealer loses");
                        System.exit(0);
                    }
                 
                }
                if(total>dealerTotal){
                    System.out.println("Player wins!");
                }else{
                    System.out.println("Dealer wins!");
                }
             break;
            }
        }
        
       
         scan.close();

    }
    public static int drawRandomCard(){
        Random random = new Random();
        int randomNumber= random.nextInt(13)+1;
        return randomNumber;
    }
    public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1: return"   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n";
            case 2: return"   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";
            case 3: return"   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            case 4: return"   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";
            case 5: return"   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";
            case 6: return"   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n";
            case 7: return"   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n";
            case 8: return"   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";
            case 9: return"   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n";
            case 10: return"   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n";
            case 11: return"   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";
            case 12: return"   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            case 13: return"   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n";
          default: return "breh u doin it wrong";
          
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    public static String hitOrStay(){
        System.out.println("\nDo you want to 'hit' or 'stay'");
        String input = scan.nextLine();
        if((input.equals("hit"))||(input.equals("stay"))){
            return input;
        }
        while(true){
            System.out.println("Please write hit or stay");
            input = scan.nextLine();
            if((input.equals("hit"))||(input.equals("stay"))){
                return input;
            }
              
         }    
        
        
        }
  
    }

