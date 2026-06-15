package utils;


import java.util.ArrayList;



public class GanttChart {



    public static void display(
            ArrayList<String> chart
    ){



        System.out.println(
        "\n========== GANTT CHART ==========");



        for(String s : chart){


            System.out.print(
            "| "+s+" "
            );


        }


        System.out.println("|");


        System.out.println(
        "================================="
        );


    }


}