package utils;


import java.util.ArrayList;



public class GanttChart {



    public static String generate(
            ArrayList<String> chart
    ){


        StringBuilder sb =
                new StringBuilder();



        sb.append(
        "\n========== GANTT CHART ==========\n"
        );



        for(String s : chart){


            sb.append(
            "| "
            )
            .append(s)
            .append(" ");


        }



        sb.append("|\n");



        sb.append(
        "=================================\n"
        );



        return sb.toString();

    }





    public static void display(
            ArrayList<String> chart
    ){


        System.out.println(
            generate(chart)
        );


    }


}