package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class MultilevelQueue implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){



        ArrayList<String> chart =
                new ArrayList<>();


        int time = 0;



        for(Process p:processes){



            chart.add(
            p.toString()
            );



            time += p.getBurstTime();



            p.setCompletionTime(time);


            p.calculateTimes();


        }



        System.out.println(
        "\n========== MULTILEVEL QUEUE =========="
        );



        GanttChart.display(chart);


        Metrics.display(processes);



    }


}