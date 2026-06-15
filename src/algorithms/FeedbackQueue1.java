package algorithms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import models.Process;

import utils.Metrics;
import utils.GanttChart;



public class FeedbackQueue1 implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){



        Queue<Process> queue =
                new LinkedList<>();


        ArrayList<String> chart =
                new ArrayList<>();


        int time = 0;



        for(Process p:processes){

            queue.add(p.copy());

        }




        while(!queue.isEmpty()){



            Process p =
            queue.poll();



            chart.add(
            p.toString()
            );



            time += p.getBurstTime();



            p.setCompletionTime(time);


            p.calculateTimes();



        }




        processes.clear();


        System.out.println(
        "\n========== FEEDBACK QUEUE 1 =========="
        );


        GanttChart.display(chart);



        Metrics.display(processes);



    }



}