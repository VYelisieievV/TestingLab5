import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class FirstTask {


    public static void GetTimeInitializeElementsInCollection(Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            long t1=System.nanoTime();
            for(double i=0; i<400000; i++)
            collection.add(i);
            long t2=System.nanoTime();
            System.out.println(collection.getClass()+" initialization time is "+Math.abs((t2-t1)/1000)+" microseconds");
        }
    }

    public static Double Finder (Double el, Collection<Double> collection)
    {
        Iterator<Double> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Double node = iterator.next();
            if (node.equals(el)) return node;
        }
        return -1.0;
    }

     public static void GetTimeFindElementInCollection(Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            Double var;
            long t1=System.nanoTime();
            var = Finder(1.0, collection);
            long t2=System.nanoTime();
            System.out.println("Finding element at the start of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            var = Finder(400000.0/2, collection);
            t2=System.nanoTime();
            System.out.println("Finding element in the middle of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            var = Finder(399999.0, collection);
            t2=System.nanoTime();
            System.out.println("Finding element in the end of "+collection.getClass()+" took "+Math.abs((t2-t1)/1000)+" microseconds");
            System.out.println("\n");
        }
    }

    public static void GetTimeRemoveElementInCollection (Collection<Double> ...collections)
    {
        for (Collection<Double>  collection : collections)
        {
            long t1=System.nanoTime();
            collection.remove(1.0);
            long t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the start in "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            collection.remove(400000.0/2);
            t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the middle in "+Math.abs((t2-t1)/1000)+" microseconds");
            t1=System.nanoTime();
            collection.remove(399999.0);
            t2=System.nanoTime();
            System.out.println(collection.getClass()+" removed element from the end in "+Math.abs((t2-t1)/1000)+" microseconds");
            System.out.println("\n");
        }
    }

    public static void main (String args[]) throws IOException
    {
        Scanner in=new Scanner(System.in);
        String TaskToExecute = "-1";
        boolean exit = false;
        Pattern format = Pattern.compile("^[1-6]?$|^0$");


        while(!exit){
            boolean check = true;
            System.out.println("\n\tEnter # of task (0 for exit)");
            while(check) {
                TaskToExecute = in.nextLine();
                Matcher matcher=format.matcher(TaskToExecute);
                if (!matcher.matches()) {
                    System.out.println("No such task!");
                    continue;
                }
                check=false;
            }
            switch (Integer.parseInt(TaskToExecute))
            {
                case 1:
                    {
                        //////////////////
                        /////1ST TASK/////
                        //////////////////
                        System.out.println("FIRST TASK:\n");
                        List<Double> arraylist = new ArrayList<>();
                        List<Double> linkedlist=new LinkedList<>();
                        Set<Double> treeset=new TreeSet<>();
                        Set<Double> hashset=new HashSet<>();

                        GetTimeInitializeElementsInCollection(arraylist, linkedlist, treeset, hashset);
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        GetTimeFindElementInCollection(arraylist, linkedlist, treeset, hashset);
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        GetTimeRemoveElementInCollection (arraylist, linkedlist, treeset, hashset);
                        break;
                    }
                case 2:
                    {
                        //////////////////
                        /////2ND TASK/////
                        //////////////////
                        System.out.println("======================================================================");
                        System.out.println("SECOND TASK\n");
                        SecondTask Task2=new SecondTask();
                        break;
                    }
                case 3:
                    {
                        //////////////////
                        /////3RD TASK/////
                        //////////////////
                        System.out.println("======================================================================");
                        System.out.println("THIRD TASK\n");
                        ThirdTask Task3 = new ThirdTask();
                        break;
                    }
                case 4:
                    {
                        //////////////////
                        /////4TH TASK/////
                        //////////////////
                        System.out.println("======================================================================");
                        System.out.println("FOURTH TASK\n");
                        FourthTask Task4 = new FourthTask();
                        break;
                    }
                case 5:
                    {
                        //////////////////
                        /////5TH TASK/////
                        //////////////////
                        System.out.println("======================================================================");
                        System.out.println("FIFTH TASK\n");
                        FifthTask Task5 = new FifthTask();
                        break;
                    }
                case 6:
                    {
                        //////////////////
                        /////6TH TASK/////
                        //////////////////
                        System.out.println("======================================================================");
                        System.out.println("SIXTH TASK\n");
                       SixthTask Task6 = new SixthTask();
                        break;
                    }
                case 0:
                    {
                        exit = true;
                        break;
                    }
            }
        }
    }
}


/*Conclusion: Array list and linked list has faster initialization then HashSet and TreeSet
* For large size collection HashSet and TreeSet are preferred.
*
* HashSet is able to delete objects within O(1), but HashSet doesn't provide an order in elements, so finding
* specific  element using iterators has random time.
*
* TreeSet provides some order to collection, so if speed of operations and order are prioritized, TreeSet
* is a choice.
* Removing elements from the start and a middle of Array list happens rapidly.
*
* Head pointer of LinkedList allows to works efficiently with its elements at the beginning*
*
* Storing small amounts of data basically eliminates advantages of each collection,
* their performance is basically the same. */
