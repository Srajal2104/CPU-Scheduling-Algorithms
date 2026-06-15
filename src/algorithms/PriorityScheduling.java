package algorithms;


import java.util.ArrayList;
import models.Process;
import utils.GanttChart;
import utils.Metrics;



public class PriorityScheduling implements Scheduler {


    @Override
    public void schedule(ArrayList<Process> processes){


        ArrayList<Process> done =
                new ArrayList<>();


        ArrayList<String> chart =
                new ArrayList<>();


        int time = 0;



        while(done.size() < processes.size()){



            Process selected = null;



            for(Process p: processes){


                if(!done.contains(p)
                && p.getArrivalTime() <= time){


                    if(selected == null ||
                    p.getPriority() < selected.getPriority()){


                        selected = p;

                    }

                }

            }



            if(selected == null){

                time++;

                continue;

            }



            chart.add(selected.toString());



            time += selected.getBurstTime();



            selected.setCompletionTime(time);


            selected.calculateTimes();



            done.add(selected);



        }



        System.out.println(
        "\n========== PRIORITY =========="
        );


        GanttChart.display(chart);


        Metrics.display(processes);


    }


}