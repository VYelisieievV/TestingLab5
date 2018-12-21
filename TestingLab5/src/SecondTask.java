import java.io.FileWriter;
import java.util.*;

public class SecondTask
{

    public static ArrayList<Integer> FillListWithRandomIntegers(ArrayList<Integer> ArrayList, int ListLen, int RandBound)
    {
        Random rand = new Random();
        for (int i = 0; i < ListLen; i = i + 1) ArrayList.add(rand.nextInt(RandBound) + 1);
        return ArrayList;
    }

    public static ArrayList<Integer> GetNMaxElementOfList(ArrayList<Integer> ArrayList, int N)
    {
        ArrayList<Integer> TempList = new ArrayList<Integer>();
        for (Integer el: ArrayList) TempList.add(el);
        Collections.sort(TempList, Collections.reverseOrder());
        for (int i=0; i<ArrayList.size()-N; i=i+1) TempList.remove(TempList.size()-1);
        return TempList;
    }

    {
        ArrayList<Integer>alpha=new ArrayList<>();
        ArrayList<Integer>beta=new ArrayList<>();

        alpha = FillListWithRandomIntegers( alpha, 150, 200);
        System.out.println("List `alpha` at the start");
        System.out.println(alpha);

        beta = GetNMaxElementOfList( alpha, 15);

        System.out.println("Beta list:");
        System.out.println(beta);
        System.out.println("Alpha list at the end");
        System.out.println(alpha);

        String FileName="TestingLab5SecondTask.txt";
        try {
            FileWriter fileWriter=new FileWriter(FileName);
            for (Integer el: beta) fileWriter.write(Integer.toString(el) + " ");
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}