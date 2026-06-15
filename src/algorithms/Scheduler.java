package algorithms;


import java.util.ArrayList;
import models.Process;



public interface Scheduler {


    void schedule(
            ArrayList<Process> processes
    );


}