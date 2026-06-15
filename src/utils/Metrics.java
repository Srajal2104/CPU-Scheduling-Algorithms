package utils;


import java.util.ArrayList;
import models.Process;



public class Metrics {



    public static double averageWaitingTime(
            ArrayList<Process> list
    ){

        double sum = 0;


        for(Process p:list){

            sum += p.getWaitingTime();

        }


        return sum/list.size();

    }





    public static double averageTurnaroundTime(
            ArrayList<Process> list
    ){

        double sum = 0;


        for(Process p:list){

            sum += p.getTurnaroundTime();

        }


        return sum/list.size();

    }





    public static void display(
            ArrayList<Process> list
    ){


        System.out.println(
        "\n========== PROCESS TABLE ==========");


        System.out.printf(
        "%-5s %-5s %-5s %-5s %-5s\n",
        "PID",
        "AT",
        "BT",
        "WT",
        "TAT"
        );



        for(Process p:list){


            System.out.printf(
            "%-5s %-5d %-5d %-5d %-5d\n",
            "P"+p.getPid(),
            p.getArrivalTime(),
            p.getBurstTime(),
            p.getWaitingTime(),
            p.getTurnaroundTime()
            );


        }



        System.out.println(
        "\nAverage Waiting Time : "
        +averageWaitingTime(list)
        );



        System.out.println(
        "Average Turnaround Time : "
        +averageTurnaroundTime(list)
        );

    }

}