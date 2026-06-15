package utils;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import models.Process;



public class InputReader {


    public static ArrayList<Process> read(
            String file
    ) throws Exception {



        ArrayList<Process> list =
                new ArrayList<>();



        try(Scanner sc = new Scanner(new File(file))) {


            while(sc.hasNextLine()) {



                int pid = sc.nextInt();

                int at = sc.nextInt();

                int bt = sc.nextInt();

                int pr = sc.nextInt();



                list.add(
                    new Process(
                        pid,
                        at,
                        bt,
                        pr
                    )
                );


            }


        }



        return list;


    }


}