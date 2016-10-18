import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import Job;

/**
 * Created by Remil on 10/17/2016.
 */
public class Scheduler {


    public static void main(String []args){
        int [][] jobs =  read_input("job.info.fcfs");
        int job_Num = jobs[0][0];
        for(int i =0; i <job_Num;i++){
            Job job_fcfs = new Job(jobs[1][i],jobs[2][i]);
        }
//        Job job_fcfs = new Job();
        System.out.format("%d", jobs[0][0]);
//        System.out.format("%d", )
    }

    private static int[][] read_input(String path){
        Scanner scanner =  null;
        int [][] jobs_prop = new int [3][];
        jobs_prop[0] = new int[1];
        jobs_prop[0][0] = 0;
        try{
            scanner = new Scanner(new File(path));
            if (scanner.hasNext()){
                jobs_prop[0][0] = scanner.nextInt();
            }
            jobs_prop[1] = new int [jobs_prop[0][0]]; // job arrive time
            jobs_prop[2] = new int  [jobs_prop[0][0]]; //  job exec time
            int i = 0;
            while(scanner.hasNextInt())
            {
                jobs_prop[1][i] = scanner.nextInt();
                jobs_prop[2][i] = scanner.nextInt();
                i ++ ;
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getClass());
            return jobs_prop;
        } finally {
            if (scanner !=  null){
                scanner.close();
            }
        }

        return jobs_prop;
    }

}
