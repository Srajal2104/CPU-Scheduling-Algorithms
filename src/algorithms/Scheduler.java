package algorithms;


import java.util.ArrayList;
import models.Process;



public interface Scheduler {


    ArrayList<String> chart = new ArrayList<>();



    void schedule(
            ArrayList<Process> processes
    );



    default ArrayList<String> getChart(){

        return chart;

    }


}