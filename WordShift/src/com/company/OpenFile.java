package com.company;
/**
 * Utilities for opening a text file. The text file can be opened for
 reading or a file can be opened for writing.
 * @author Ishika
 * @version 2.0
 * @since August 23, 16
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFile{
    public static void main(String[] args){
        Scanner infile = null;

        infile = OpenFile.openToRead("g.txt");

        PrintWriter outfile = OpenFile.openToWrite("gcopy.txt");
        String temp = null;

        while(infile.hasNext()){
            temp = infile.nextLine();
            System.out.println(temp);
            outfile.println(temp);
        }

        infile.close();
        outfile.close();
    }

    /**
     * Opens a file for reading
     * @param fileString            The name of the file to be opened
     * @return                                      Scanner instance of the file to be opened
     * */

    public static Scanner openToRead(String fileString) {
        File fileName = new File(fileString);
        Scanner fromFile = null;
        try {
            fromFile = new Scanner(fileName);
        } catch(FileNotFoundException e){
            System.out.println("Not able to open file.");
        }

        return fromFile;
    }

    /**
     * Opens a file for writing
     * @param fileString            The name of the file to be created and written to
     * @return                      PrintWriter instance of the file to be created and written to
     * */

    public static PrintWriter openToWrite(String fileString){
        PrintWriter outFile = null;
        try{
            outFile = new PrintWriter(fileString);
        } catch(FileNotFoundException e){
            System.out.println("Sorry! The file couldn't be created.");
            System.exit(1);
        }

        return outFile;
    }

//    public static String readFile(String fileName) throws FileNotFoundException {
//        Scanner infile = openToRead(fileName);
//        String temp = "";
//
//        while(infile.hasNext()){
//            temp = temp + infile.nextLine() + " ";
//        }
//
//        infile.close();
//
//        return temp.toString();
//    }

    public static String readFile(String fileName) throws FileNotFoundException {
        Scanner infile = openToRead(fileName);
        StringBuilder temp = new StringBuilder();

        while(infile.hasNext()){
            temp.append(infile.nextLine()).append(" ");
        }
        infile.close();

        return temp.toString();
    }
}