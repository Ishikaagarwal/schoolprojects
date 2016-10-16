package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    /**
     *  Sets up and runs Decipher.
     *  @param  args     An array of String arguments (not used here).
     */
    public static void main(String [] args)
    {
        String key = getInfo("\n\nPlease enter the encryption key: ");

        /**    The name of the text file to be encrypted or decrypted, chosen by the user.    */
        String fileNameIn = getInfo("\n\nPlease enter the name of the text file to encrypt/decrypt: ");

        /**    The name of the text file to be created, chosen by the user.    */
        String fileNameOut = getInfo("\n\nPlease enter the name of the new text fle to be created  : ");

        /**    The choice made by the user.  "1" to encrypt, and "2" to decrypt.
         */
        String choice = getInfo("\n\nPlease enter (1) to encrypt or (2) to decrypt            : ");

        Decipher decipher = new Decipher(key);

        String txtInput = getTxtInput(fileNameIn);
        String output;
        if (choice.equals("1")){
            output = decipher.encrypt(txtInput);
        } else {
            output = decipher.decrypt(txtInput);
        }

        System.out.println(output);

        writeToFile(fileNameOut, output);
    }

    /**
     *  Prompts the user for the 4 Strings necessary to create the
     encrypted/decrypted output and file.
     * @param  askPhrase    What the user will be prompted to do
     * @return              The String entered by the user
     */
    private static String getInfo (String askPhrase)
    {
        return Prompt.getString(askPhrase);
    }


    /**
     * Using OpenFiles' openToRead() method, a Scanner is made and used to read the
     * input text file
     * @param fileNameIn        String name of the file that the user has entered text into for this program
     * @return                  String txtInput contains the entire text file contents
     */
    private static String getTxtInput(String fileNameIn)
    {
        Scanner infile = OpenFile.openToRead(fileNameIn);
        String txtInput = "";

        while(infile.hasNext()){
            txtInput += infile.nextLine() + "\n";
        }

        infile.close();
        return txtInput;
    }


    /**
     * Using OpenFiles' openToWrite() method, a PrintWriter is made and used to "print"
     * the encrypted/decrypted text into a file
     * @param fileNameOut       String name of the file that the user wants the encrypted/decrypted output to be printed to
     * @param output            String that contains the encrypted/decrypted output
     */
    private static void writeToFile(String fileNameOut, String output) {
        PrintWriter writer = OpenFile.openToWrite(fileNameOut);
        writer.println(output);
        writer.close();
    }


}
