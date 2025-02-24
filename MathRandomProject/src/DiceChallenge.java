
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class DiceChallenge {


    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int[] dice = new int[5];
        ArrayList <Character> savedDice = new ArrayList<>();

        System.out.println("""
                Welcome to the Dice Challenge!
                Type start to roll your dice!
                
                """);
        while (true) {
            System.out.print("""
                    Here is your roll:
                    enter the dice you want to keep
                    enter all to reroll your dice!
                    PRESS ENTER TO FINISH YOUR TURN
                    """);
            var rolling = Arrays.stream(dice).map(s -> rand.nextInt(1, 6)).limit(5 - savedDice.size()).toArray();
            System.out.println(Arrays.toString(rolling));
            String decision = input.nextLine();
            if (rolling.length == 0) {
                System.exit(0);
            }
            if (decision.isEmpty()){
                System.out.println("Turn is over.");
                System.out.println(Arrays.toString(dice));
                break;
            } else if (decision.equalsIgnoreCase("all")) {
                System.out.println("All remaining dice have been rerolled.");
            } else {
                for (char c : decision.toCharArray()) {
                   selectDice(c, savedDice);
                }
            }


        }
    }

    public static void selectDice(char choice, ArrayList<Character> savedDice){
        if (savedDice.size() < 6) {
            savedDice.add(choice);
        } else {
            System.out.print("You can only save 5 dice!");
        }
    }
}
