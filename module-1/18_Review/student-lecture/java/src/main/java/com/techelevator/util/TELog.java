package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class TELog {

    private static PrintWriter writer;
    private static final FileOutputStream stream = null;



    public static void log(String message){
        if(writer == null){
            try(FileOutputStream stream = new FileOutputStream("logs/search.log")){
                writer = new PrintWriter(stream);
                writer.println(message);
                writer.flush();

        }catch(Exception anyException){
            throw new TELogException(anyException.getMessage());
        }
        }else{
            try {
                writer.println(message);
                writer.flush();

            }catch(Exception anyException){
                throw new TELogException(anyException.getMessage());
            }
        }
    }


}
