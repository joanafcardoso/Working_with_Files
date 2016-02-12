package io;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cardoso on 10-Feb-16.
 */
public class WriteReadSort {
    public static void main(String[] args) throws IOException {
        new WriteReadSort().writeThenRead();
        new WriteReadSort().sortLines();
    }

    String fileName = "ToSort.txt";

    private void writeThenRead() throws IOException {
        FileWriter writer;
        char[] n = new char[100];
        FileReader reader;
        try {
            writer = new FileWriter(fileName);
            writer.write("70.920 -38.797 14.354 99.323 90.374 7.581\n-37.507 -3.263 40.079 27.999 65.213 -55.552");
            writer.flush();
            writer.close();

            reader = new FileReader(fileName);
            reader.read(n);
            for (char c : n) {
                System.out.print(c);
            }
            reader.close();
            System.out.println("");
        } catch (IOException e) {
            System.out.println("File read write error" + e.getMessage());
        }
    }

    private void sortLines()throws FileNotFoundException{
        String fileName = "ToSort.txt";
        try {
            // scanner to read the file
            Scanner scanner = new Scanner(new File(fileName));
            List<String> temp = new LinkedList<>();

            //start reading from the file, store all the lines in the list
            while (scanner.hasNextLine()) {
                String num = scanner.nextLine();
                temp.add(num);
            }
            scanner.close();
            String[] str = temp.toArray(new String[2]);
            //String[] str = temp.toArray(new String[0]);//if the number of lines is unknown

            /**
             * for each string in str array, split it using space as the delimiter and store the split strings in an array,
             * for each string value in the array, convert it into Double and store it in a collection
             * Sort the collection, convert it into String
             */
            for (int i = 0; i < str.length; i++) {
                List<Double> num = new LinkedList<>();
                String[] arr = str[i].split("\\s");
                for (int j = 0; j < arr.length; j++) {
                    Double currentNumber = Double.valueOf(arr[j]);
                    num.add(currentNumber);
                }
                Collections.sort(num);
                String sortedNumbers = num.toString();
                int indexOfOpenBracket = sortedNumbers.indexOf("[");
                int indexOfLastBracket = sortedNumbers.lastIndexOf("]");
                System.out.println("");
                System.out.println(sortedNumbers.substring(indexOfOpenBracket + 1, indexOfLastBracket));
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
