import java.util.*;
import java.util.Scanner;
import java.util.regex.*;

public class FourthTask {
    public static class Game
    {
        private static int Number;
        private static int LeftBoarder;
        private static int RightBoarder;
        private static int counter = 0;

        {
            Random random = new Random();
            Number =random.nextInt(100)+1;
            LeftBoarder=0;
            RightBoarder=100;
            Pattern format = Pattern.compile("^0$|^[1-9][0-9]?$|^100$");

            System.out.println("Welcome to `Rashetka u Bonda` (Ugadaika) game!\n");
            System.out.println("The rules:\n" +
                    "1. Computer picks a number in a specific range.\n" +
                    "2. Try to guess computer's pick! Input an integer in the given range.\n" +
                    "3. If you guess , you pass rashetka!\n\n");
            Scanner in = new Scanner(System.in);
            String UserInput = "0";
            System.out.println("Lets start a game!\n\n");

            while(Integer.parseInt(UserInput)!=Number)
            {
                boolean IsDefenceActive=true;
                System.out.println("Input an integer in range:  [" + LeftBoarder + "," + RightBoarder + "]");
                while(IsDefenceActive) {
                    UserInput = in.nextLine();
                    Matcher matcher=format.matcher(UserInput);
                    if (!matcher.matches()) {
                        System.out.println("Incorrect input!");
                        continue;
                    }
                    if(Integer.parseInt(UserInput)<LeftBoarder||Integer.parseInt(UserInput)>RightBoarder){
                        System.out.println("Your integer is out of bounds!");
                        continue;
                    }
                    IsDefenceActive=false;
                }
                counter++;
                if(Integer.parseInt(UserInput) == Number)
                {
                    System.out.println("Congratulations! You win! You made "+ counter +" guesses =)");
                    break;
                }
                if(Integer.parseInt(UserInput)>Number) {
                    RightBoarder = Integer.parseInt(UserInput);
                    System.out.println("Its ... too much, Goku!");
                }
                else {
                    LeftBoarder=Integer.parseInt(UserInput);
                    System.out.println("... Take it bigger!");
                }

            }

        }

    }


    {
        Game Bondaranko = new Game();
    }

}
