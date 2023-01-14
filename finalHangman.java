import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class finalHangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = words[randomWord()];
        char[] array = word.toCharArray();
        char[] secArray = new char[word.length()];
        char[] thirdArray = new char[word.length()];
        for(int i = 0;i<secArray.length;i++){
            secArray[i]='_';
        }
        int count = 0;
        int length = 0;
        char[] missArray = new char[20];
        while(count<7){
            System.out.println();
            System.out.println(gallows[count]);
            System.out.print("Word:\t");
            printPlaceHolders(secArray);
            System.out.print("\n\nGuess:\t");
            char guess = scan.next().charAt(0);
            System.out.println();
            missArray = printMissedGuess(secArray, array, word, guess, missArray, length);
            if (!word.contains(Character.toString(guess))) {
                length++;
                count++;
              }
            for (int i = 0; i < missArray.length; i++) {
                 if(missArray[i] != '\u0000'){
                System.out.print(missArray[i] + " ");     
            }
              }
            thirdArray = updatePlaceHolders(array, secArray, word, guess);
            for(int i = 0;i<thirdArray.length;i++){
                if(Arrays.equals(array, thirdArray)){
                    System.out.println("\n");
                    System.out.println("Word: " + updatePlaceHolders(array, secArray, word, guess));
                    System.out.println("\nu won");
                    System.exit(0);
                }
            }
            if(count == 6){
                System.out.println("\n");
                System.out.print(gallows[6]);
                System.out.println("\nYou lost");
                System.exit(0);
            }
        } 
    }
    public static int randomWord(){
        double number = (Math.random() * (words.length));
        return (int) number;
    }
    public static void printPlaceHolders(char[] secArray){
        for(int i = 0;i<secArray.length;i++){
            System.out.print(secArray[i]+" ");
        }
    }
    public static char[] updatePlaceHolders(char[] array, char[] secArray, String word, char guess){
        if(word.contains(Character.toString(guess))){
            for(int i = 0;i<secArray.length;i++){
                if(array[i]==guess){
                    secArray[i]=guess;   
                }
            }
       }
       return secArray;
    }
    public static char[] printMissedGuess(char[] secArray, char[] array, String word, char guess, char[] missArray, int length){
        System.out.print("Misses:\t");
        if(!word.contains(Character.toString(guess))){
                 missArray[length] = guess;
        }
        return missArray;
    }
}




