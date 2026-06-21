package algorithms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class MLFQ implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){



        Queue<Process> q1 =
                new LinkedList<>();


        Queue<Process> q2 =
                new LinkedList<>();



        chart.clear();



        ArrayList<Integer> remaining =
                new ArrayList<>();



        for(Process p : processes){


            q1.add(
                p.copy()
            );


            remaining.add(
                p.getBurstTime()
            );

        }





        int time = 0;



        while(!q1.isEmpty()
        || !q2.isEmpty()){



            Process current;



            if(!q1.isEmpty()){

                current = q1.poll();

            }
            else{

                current = q2.poll();

            }



            int index =
            processes.indexOf(
                processes.stream()
                .filter(x ->
                    x.getPid()
                    ==
                    current.getPid()
                )
                .findFirst()
                .get()
            );



            chart.add(
                current.toString()
            );




            int quantum = 2;



            int run =
            Math.min(
                quantum,
                remaining.get(index)
            );



            time += run;



            remaining.set(
                index,
                remaining.get(index)-run
            );





            if(remaining.get(index)>0){



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