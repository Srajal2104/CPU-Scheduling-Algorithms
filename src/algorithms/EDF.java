package algorithms;


import java.util.ArrayList;
import java.util.Comparator;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class EDF implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){


        processes.sort(
        Comparator.comparingInt(
        Process::getPriority
        )
        );



        ArrayList<String> chart =
                new ArrayList<>();



        int time=0;



        for(Process p:processes){


            chart.add(
            p.toString()
            );


            time += p.getBurstTime();



            p.setCompletionTime(time);


            p.calculateTimes();



        }



        System.out.println(
        "\n========== EDF =========="
        );



        GanttChart.display(chart);


        Metrics.display(processes);



    }


}