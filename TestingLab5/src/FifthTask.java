import java.io.*;
import java.io.IOException;
import java.util.*;

public class FifthTask {

    public static ArrayList<String> GetTextFromFile (String path) throws IOException
    {
        File file = new File(path);
        ArrayList<String> text = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line!=null)) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                text.add(words[i]);
            }
            line = bufferedReader.readLine();
        }
        return text;
    }

    public static void Print(List<String> list)
    {
        for(String i : list)
            System.out.println(i);
    }

     {
        String Ukrainian = "textukr.txt";
        String English = "texteng.txt";
        String Russian = "textru.txt";

        ArrayList<String> UkrText = new ArrayList<>();
        ArrayList<String> EngText = new ArrayList<>();
        ArrayList<String> RuText = new ArrayList<>();

        try{
        UkrText = GetTextFromFile(Ukrainian);
        EngText = GetTextFromFile(English);
        RuText = GetTextFromFile(Russian);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
     Collections.sort(UkrText, String.CASE_INSENSITIVE_ORDER);
     Collections.sort(EngText, String.CASE_INSENSITIVE_ORDER);
     Collections.sort(RuText, String.CASE_INSENSITIVE_ORDER);

        System.out.println("Ukrainian\n");
        Print(UkrText);
        System.out.println("\nEnglish\n");
        Print(EngText);
        System.out.println("\nRussian\n");
        Print(RuText);

    }

}
