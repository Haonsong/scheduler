/**
 * Created by Remil on 10/18/2016.
 */



public class Job {
//    private static final int RRIVE = 0;
    public static final int NOT_ARRIVE = 0;
    public static final int QUEUE      = 1;
    public static final int RUNNING    = 2;
    public static final int FINISHED   = 3;
//    final public static int NOT_START

    private double arr_Time;
    private double start_Time;
    private double execute_Time;
    private int status;

    public Job (double arr_Time,  double execute_Time ){
        this.arr_Time = arr_Time;
        this.execute_Time = execute_Time;
        this.start_Time = -99999999;
        this.status = NOT_ARRIVE;
    }


    public int Get_Status(double cur_Time){
        if(cur_Time <this.arr_Time ) return NOT_ARRIVE;
        else if(cur_Time >= this.arr_Time ) return QUEUE;
        else if(status ==  RUNNING && cur_Time <= this.start_Time + this.execute_Time ) return RUNNING;
        else {
            return FINISHED;
        }
    }

    public boolean Start (double cur_Time){
        if (cur_Time >= this.arr_Time){
            this.start_Time = cur_Time;
            return true;
        }
        return false;
    }
}
