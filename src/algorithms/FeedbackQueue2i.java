package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class FeedbackQueue2i implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){



        ArrayList<String> chart =
                new ArrayList<>();


        int time = 0;


        int quantum = 2;



        for(Process p:processes){



            chart.add(
            p.toString()
            );



            int run =
            Math.min(
            quantum,
            p.getBurstTime()
            );



            time += run;



            p.setCompletionTime(time);


            p.calculateTimes();



        }




        System.out.println(
        "\n========== FEEDBACK QUEUE 2i =========="
        );



        GanttChart.display(chart);



        Metrics.display(processes);



    }


}