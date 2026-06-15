package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class SPN implements Scheduler {



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



            Process selected = null;



            for(Process p:list){



                if(p.getArrivalTime() <= time){



                    if(selected == null ||
                    p.getBurstTime()
                    < selected.getBurstTime()){


                        selected = p;

                    }


                }

            }




            if(selected == null){

                time++;

                continue;

            }




            list.remove(selected);



            chart.add(
            selected.toString()
            );



            time += selected.getBurstTime();



            selected.setCompletionTime(time);



            selected.calculateTimes();


        }





        System.out.println(
        "\n========== SPN =========="
        );



        GanttChart.display(chart);



        Metrics.display(processes);



    }


}