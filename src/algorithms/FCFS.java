package algorithms;


import java.util.ArrayList;
import java.util.Comparator;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class FCFS implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){


        processes.sort(
        Comparator.comparingInt(
        Process::getArrivalTime
        )
        );



        int time = 0;


        ArrayList<String> chart =
                new ArrayList<>();



        for(Process p : processes){



            if(time < p.getArrivalTime()){

                time = p.getArrivalTime();

            }



            chart.add(
            p.toString()
            );



            time += p.getBurstTime();



            p.setCompletionTime(time);


            p.calculateTimes();


        }



        System.out.println(
        "\n========== FCFS =========="
        );



        GanttChart.display(chart);


        Metrics.display(processes);


    }

}