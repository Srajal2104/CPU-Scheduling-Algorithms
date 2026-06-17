package utils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ResultWriter {


    public static void write(
            String fileName,
            String content
    ) {


        File file = new File(
                "../results/" + fileName
        );


        try {


            File parent =
                    file.getParentFile();


            if(parent != null){

                parent.mkdirs();

            }



            try(FileWriter writer =
                    new FileWriter(file)){


                writer.write(content);

            }



            System.out.println(
                    "Result saved : "
                    + file.getPath()
            );



        }
        catch(IOException e){


            e.printStackTrace();

        }


    }


}