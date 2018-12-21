import java.util.*;
import java.lang.Comparable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ThirdTask
{
    public static abstract class Worker implements Comparable<Worker> {
        private String Name;
        private long id;
        protected double AverageSalary;

        public String GetName()
        {
            return Name;
        }
        public long GetId()
        {
            return id;
        }
        public void SetName(String Name)
        {
            this.Name = Name;
        }
        public void SetId(long id)
        {
            this.id = id;
        }
        public Worker(String Name,long id)
        {
            this.Name=Name;
            this.id=id;
        }
        public Worker()
        {
            this.Name="default";
            this.id=1;
        }

        public abstract double GetMonthSalary();

        @Override
        public int compareTo(Worker o) {
            if(this.GetMonthSalary()<o.GetMonthSalary())
                return 1;
            if(this.GetMonthSalary()>o.GetMonthSalary())
                return -1;
            else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(this.Name,o.Name);
            }
        }
    }

    public static class HourSalaryWorker extends Worker {
        private double HourSalary;

        public double GetHourSalary() {
            return HourSalary;
        }

        public void SetHourSalary(int HourSalary) {
            this.HourSalary = HourSalary;
        }

        @Override
        public double GetMonthSalary() {
            AverageSalary = 20.8 * 8 * HourSalary;
            return 20.8 * 8 * HourSalary;
        }

        public HourSalaryWorker(String Name, long id, double HourSalary)
        {
            super(Name, id);
            this.HourSalary = HourSalary;
            GetMonthSalary();
        }

        public HourSalaryWorker()
        {
            super();
            this.HourSalary=0;
            GetMonthSalary();
        }

        @Override
        public String toString()
        {
            return "Name: "+super.Name+"\nWorker's type: Hour Salary Worker\nid: "+super.id+"\nAverage Salary: "+super.AverageSalary+"\n";
        }
    }
    public static class FixedSalaryWorker extends Worker {

        private double FixedSalary;

        public double GetFixedSalary() {
            return FixedSalary;
        }

        public void SetMonthlySalary(double FixedSalary) {
            this.FixedSalary = FixedSalary;
        }

        @Override
        public double GetMonthSalary(){
            AverageSalary=FixedSalary;
            return AverageSalary;
        }

        public FixedSalaryWorker(String Name, long id, double FixedSalary) {
            super(Name, id);
            this.FixedSalary=FixedSalary;
            GetMonthSalary();
        }
        public FixedSalaryWorker(){
            super();
            FixedSalary=0;
            GetMonthSalary();
        }
        @Override
        public String toString()
        {
            return "Name: "+super.Name+"\nWorker's type: Fixed Salary Worker\nid :"+super.id+"\nAverage Salary: "+super.AverageSalary+"\n";
        }
    }

    public static ArrayList<Worker> RandomInitializeWorkerList(int size, String[] Names, int Names_size)
    {
        ArrayList<Worker>  Workers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++)
        {
            if (random.nextBoolean()) {
                if (random.nextBoolean())
                    Workers.add(new HourSalaryWorker(Names[random.nextInt(Names_size)], random.nextInt(999999), random.nextDouble()));
                else
                    Workers.add(new HourSalaryWorker(Names[random.nextInt(Names_size)], random.nextInt(999999), 75.0));
            }
            else
            {
                if(random.nextBoolean())
                    Workers.add(new FixedSalaryWorker(Names[random.nextInt(Names_size)], random.nextInt(999999), random.nextDouble()));
                else
                    Workers.add(new FixedSalaryWorker(Names[random.nextInt(Names_size)], random.nextInt(999999), 13205));
            }
        }
        Collections.sort(Workers);
        return Workers;
    }

    public static void WriteWorkersToFile(ArrayList<Worker> workers, String filename) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        for (Worker worker: workers) fileWriter.write(worker.toString()+"\n\n");
        fileWriter.close();
    }

    public static String GetVariablesFromNextFileLine(String Category, String sep,Scanner scanner)
    {
        String[] NextLine = scanner.nextLine().split(sep);
        if (!NextLine[0].replaceAll("\\s+","").equals(Category)) throw new IllegalArgumentException("Wrong file format");
        return NextLine[1].replaceAll("\\s+","");
    }

    public static ArrayList<Worker> InitializeWorkersFromFile(String Filename) throws IOException
    {
        File file = new File(Filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Worker> WorkersList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            if (!scanner.nextLine().equals("Worker:")) throw new IllegalArgumentException("Wrong file format");

            String name = GetVariablesFromNextFileLine("Name", ":", scanner);
            long id = Long.parseLong(GetVariablesFromNextFileLine("id", ":", scanner));
            String type = GetVariablesFromNextFileLine("Type", ":", scanner);


            if (type.equals("FixedSalary")) {
                double fixed = Double.parseDouble(GetVariablesFromNextFileLine("Salary", ":", scanner));
                FixedSalaryWorker wrk = new FixedSalaryWorker(name, id, fixed);
                WorkersList.add(wrk);
            } else if (type.equals("HourSalary")) {
                double hour = Double.parseDouble(GetVariablesFromNextFileLine("Salary", ":", scanner));
                Worker wrk = new HourSalaryWorker(name, id, hour);
                WorkersList.add(wrk);
            } else throw new IllegalArgumentException("Wrong file format");
        }
    return WorkersList;
    }

    {
        ArrayList<Worker> Workers = new ArrayList<Worker>();
        try {
            Workers = InitializeWorkersFromFile("Workers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(Workers);

        System.out.println("Workers: \n");
        for (int i = 0; i < Workers.size(); i++) System.out.println(Workers.get(i).toString());

        //write sorted list to file
        try {
            WriteWorkersToFile(Workers, "SortedWorkers");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("First five names of workers");
        for (int i = 0; i < 5; i++) System.out.println("Name: " + Workers.get(i).GetName());

        System.out.println("\n" + "Last three id-s of workers");
        for (int i = Workers.size() - 3; i < Workers.size(); i++)
            System.out.println("id: " + Long.toString(Workers.get(i).GetId()));
    }
}
// String[] Names = {"Valeriy", "Vladimir", "Vasiliy", "Veneamin", "Vsevolod", "Vadim", "Victor", "Vladislav", "Valentin", "Valerian", "Vitaliy", "Vyacheslav", "Vlas", "Vikentiy", "Vit"};
// ArrayList<Worker> Workers = RandomInitializeWorkerList(10, Names, 15);