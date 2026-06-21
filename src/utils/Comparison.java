package utils;


import java.util.ArrayList;

import algorithms.*;

import models.Process;



public class Comparison {



    public static void run(
            ArrayList<Process> input
    ){



        StringBuilder result =
                new StringBuilder();




        result.append(
        "====================================\n"
        );

        result.append(
        " CPU SCHEDULING COMPARISON\n"
        );

        result.append(
        "====================================\n\n"
        );



        result.append(
        "Algorithm\t\tAvg WT\t\tAvg TAT\n\n"
        );




        double minWT =
                Double.MAX_VALUE;


        double minTAT =
                Double.MAX_VALUE;



        ArrayList<String> bestWTList =
                new ArrayList<>();


        ArrayList<String> bestTATList =
                new ArrayList<>();







        Scheduler[] schedulers = {


                new FCFS(),

                new SJF(),

                new RoundRobin(2),

                new PriorityScheduling(),

                new HRRN(),

                new SRT()


        };







        for(Scheduler scheduler : schedulers){





            ArrayList<Process> copy =
                    new ArrayList<>();





            for(Process p : input){


                copy.add(
                    p.copy()
                );


            }







            scheduler.schedule(copy);







            double wt =
            Metrics.averageWaitingTime(copy);




            double tat =
            Metrics.averageTurnaroundTime(copy);








            result.append(

            scheduler.getClass()
            .getSimpleName()

            )

            .append("\t\t")

            .append(wt)

            .append("\t\t")

            .append(tat)

            .append("\n");









            String name =
            scheduler.getClass()
            .getSimpleName();






            // Best Waiting Time

            if(wt < minWT){


                minWT = wt;


                bestWTList.clear();


                bestWTList.add(name);


            }
            else if(wt == minWT){


                bestWTList.add(name);


            }








            // Best Turnaround Time

            if(tat < minTAT){


                minTAT = tat;


                bestTATList.clear();


                bestTATList.add(name);


            }
            else if(tat == minTAT){


                bestTATList.add(name);


            }







        }






        result.append(
        "\n\n"
        );



        result.append(
        "Best Waiting Time Algorithm : "
        )
        .append(bestWTList)
        .append("\n");





        result.append(
        "Best Turnaround Time Algorithm : "
        )
        .append(bestTATList)
        .append("\n");







        ResultWriter.write(

        "Comparison.txt",

        result.toString()

        );




    }




}