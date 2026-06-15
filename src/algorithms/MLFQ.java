package algorithms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import models.Process;

import utils.Metrics;
import utils.GanttChart;



public class MLFQ implements Scheduler {


    @Override
    public void schedule(
            ArrayList<Process> processes
    ){


        Queue<Process> q1 =
                new LinkedList<>();


        Queue<Process> q2 =
                new LinkedList<>();


        ArrayList<String> chart =
                new ArrayList<>();


        int time = 0;



        for(Process p:processes){

            q1.add(p.copy());

        }



        while(!q1.isEmpty()
        || !q2.isEmpty()){



            Process current;



            if(!q1.isEmpty()){

                current=q1.poll();

            }
            else{

                current=q2.poll();

            }



            chart.add(
            current.toString()
            );



            int quantum = 2;



            int run =
            Math.min(
            quantum,
            current.getBurstTime()
            );



            time += run;



            if(run <
            current.getBurstTime()){


                q2.add(current);


            }
            else{


                current.setCompletionTime(time);

                current.calculateTimes();


            }


        }




        System.out.println(
        "\n========== MLFQ =========="
        );


        GanttChart.display(chart);


        Metrics.display(processes);



    }


}