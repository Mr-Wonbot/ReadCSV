/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author A-Rod
 */
public class ReadCSV {
    
    private static final String fileName = "C:\\Users\\A-Rod.CSCTeam-PC\\Desktop\\BrowAndRoot.csv";
    private static String fileOutput = "C:\\Users\\A-Rod.CSCTeam-PC\\Desktop\\ResultBrowAndRoot.csv";
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here 

        String thisLine = null;

        List<String> Stop = new ArrayList<>();
        int inc = 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                String[] nextLine = null;
                //Replaces  "Cart "  with  "New Page"
                if (5 == nextLine[0].length()) {
                    Stop.add("New Page " + String.valueOf(inc));
                    inc++;
                } //else, add data if it is not an empty cell or a string that we dont need  
                else if (!(nextLine[0].equals("") || nextLine[0].length() >= 4)) {
                    Stop.add(nextLine[0]);
                }
                Stop.add(0, "STOP");//adds this string at the top of the arraylist
                Stop.add(1, "");//adds an empty cell 
                StopArrays(Stop);//calls to writing method
                // System.out.println(nextLine[2]);
            }

        } catch (IOException e) {
        }

    }

    public static void StopArrays(List<String> Stop) throws Exception {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileOutput))) {
            PrintWriter writer = new PrintWriter(out);

            String[] StopArray = Stop.toArray(new String[Stop.size()]); //converts arraylist to array[]

            String[] wrap = new String[2];//this array will only serve to hold one element after each loop in enters

            for (String s : StopArray) //enhance for loop. stores StopArray to s
            {
                wrap[0] = s;            //store s to the array, wrap[]

                // wrap[1] = "dog"; if we add this, it will print on the next column. We may have
                // to write all of our information in this one write method, unless theres another way...
                writer.println(Arrays.toString(wrap)); //writes the current array to the csv file
            }
        }
    }

}
