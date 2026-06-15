package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class SJF implements Scheduler {



    @Override
    public void schedule(
            ArrayList<Process> processes
    ){


        ArrayList<Process> list =
                new ArrayList<>(processes);



        ArrayList<String> chart =
                new ArrayList<>();



        int time = 0;



        while(!list.isEmpty()){



            Process shortest = null;



            for(Process p:list){



                if(p.getArrivalTime() <= time){



                    if(shortest == null ||
                    p.getBurstTime()
                    < shortest.getBurstTime()){


                        shortest = p;

                    }

                }

            }



            if(shortest == null){


                time++;

                continue;

            }



            list.remove(shortest);



            chart.add(
            shortest.toString()
            );



            time += shortest.getBurstTime();



            shortest.setCompletionTime(time);


            shortest.calculateTimes();



        }



        System.out.println(
        "\n========== SJF =========="
        );



        GanttChart.display(chart);


        Metrics.display(processes);



    }


}