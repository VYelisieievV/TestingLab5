import java.util.Scanner;

public class SixthTask {
    private static String string;
    private static String reverse;

    public static String reverseString(){
        String reversed = "" ;
        for (int i=string.length()-1; i>=0; i--) reversed += string.charAt(i);
        return reversed;
    }

        {
            System.out.println("\nInput a string:\n");
            Scanner in = new Scanner(System.in);
            string = in.nextLine();
            reverse = reverseString();
            System.out.println("\nReverse: "+reverse);
        }
}
