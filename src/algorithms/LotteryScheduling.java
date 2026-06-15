package algorithms;


import java.util.ArrayList;
import java.util.Random;


import models.Process;

import utils.Metrics;
import utils.GanttChart;



public class LotteryScheduling implements Scheduler {


    @Override
    public void schedule(
            ArrayList<Process> processes
    ){


        ArrayList<String> chart =
                new ArrayList<>();


        Random random =
                new Random();



        int time=0;



        ArrayList<Process> list =
                new ArrayList<>();


        for(Process p:processes){

            list.add(p.copy());

        }



        while(!list.isEmpty()){


            int index =
            random.nextInt(
            list.size()
            );


            Process p =
            list.remove(index);



            chart.add(
            p.toString()
            );



            time += p.getBurstTime();



            p.setCompletionTime(time);


            p.calculateTimes();



        }




        System.out.println(
        "\n========== LOTTERY =========="
        );


        GanttChart.display(chart);


        Metrics.display(processes);



    }


}