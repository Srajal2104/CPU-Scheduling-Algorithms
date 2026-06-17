import algorithms.*;
import java.util.ArrayList;
import java.util.Scanner;
import models.Process;
import utils.GanttChart;
import utils.ResultWriter;



public class Main {


    public static void main(String[] args) {


        try(Scanner sc = new Scanner(System.in)) {


            ArrayList<Process> processes =
                    new ArrayList<>();



            System.out.println(
            "===================================="
            );

            System.out.println(
            " CPU SCHEDULING SIMULATOR"
            );

            System.out.println(
            "===================================="
            );



            System.out.print(
            "Enter number of processes: "
            );


            int n = sc.nextInt();




            for(int i=1;i<=n;i++){


                System.out.println(
                "\nProcess " + i
                );


                System.out.print(
                "Arrival Time : "
                );

                int at = sc.nextInt();



                System.out.print(
                "Burst Time : "
                );

                int bt = sc.nextInt();



                System.out.print(
                "Priority : "
                );

                int pr = sc.nextInt();




                processes.add(
                    new Process(
                        i,
                        at,
                        bt,
                        pr
                    )
                );


            }






            System.out.println(
            "\n========== ALGORITHMS =========="
            );


            System.out.println("1. FCFS");
            System.out.println("2. Round Robin");
            System.out.println("3. SJF");
            System.out.println("4. SRT");
            System.out.println("5. Priority Scheduling");
            System.out.println("6. HRRN");
            System.out.println("7. Multilevel Queue");
            System.out.println("8. MLFQ");
            System.out.println("9. Feedback Queue 1");
            System.out.println("10. Feedback Queue 2i");
            System.out.println("11. Lottery Scheduling");
            System.out.println("12. Aging");
            System.out.println("13. EDF");
            System.out.println("14. Rate Monotonic");



            System.out.print(
            "\nChoose Algorithm : "
            );


            int choice = sc.nextInt();




            Scheduler scheduler = switch(choice){


                case 1 ->
                    new FCFS();



                case 2 -> {


                    System.out.print(
                    "Enter Time Quantum : "
                    );


                    int q = sc.nextInt();


                    yield new RoundRobin(q);

                }



                case 3 ->
                    new SJF();



                case 4 ->
                    new SRT();



                case 5 ->
                    new PriorityScheduling();



                case 6 ->
                    new HRRN();



                case 7 ->
                    new MultilevelQueue();



                case 8 ->
                    new MLFQ();



                case 9 ->
                    new FeedbackQueue1();



                case 10 ->
                    new FeedbackQueue2i();



                case 11 ->
                    new LotteryScheduling();



                case 12 ->
                    new Aging();



                case 13 ->
                    new EDF();



                case 14 ->
                    new RateMonotonic();




                default -> {

                    System.out.println(
                    "Invalid Choice"
                    );

                    yield null;

                }


            };





            if(scheduler != null){



                scheduler.schedule(processes);




                String algorithmName =
                scheduler.getClass()
                .getSimpleName();




                StringBuilder result =
                new StringBuilder();





                result.append(
                "====================================\n"
                );


                result.append(
                " CPU SCHEDULING RESULT\n"
                );


                result.append(
                "====================================\n\n"
                );



                result.append(
                "Algorithm : "
                )
                .append(algorithmName)
                .append("\n\n");





                // GANTT CHART SAVE

                result.append(
                GanttChart.generate(
                    scheduler.getChart()
                )
                );





                result.append(
                "\nProcess Details\n"
                );

                result.append(
                "------------------------------------\n"
                );



                result.append(
                "PID\tAT\tBT\tWT\tTAT\n\n"
                );




                for(Process p : processes){



                    result.append(
                    "P"
                    )
                    .append(
                    p.getPid()
                    )
                    .append("\t")
                    .append(
                    p.getArrivalTime()
                    )
                    .append("\t")
                    .append(
                    p.getBurstTime()
                    )
                    .append("\t")
                    .append(
                    p.getWaitingTime()
                    )
                    .append("\t")
                    .append(
                    p.getTurnaroundTime()
                    )
                    .append("\n");


                }





                result.append(
                "\n\nExecution Completed Successfully\n"
                );





                ResultWriter.write(

                algorithmName + "_Result.txt",

                result.toString()

                );



            }




        }


    }


}