package io;

import java.io.*;
import java.util.*;

/**
 * Created by Cardoso on 09-Feb-16.
 */
public class WriteReadSum{

    public static void main(String[] args) throws IOException {
        new WriteReadSum().writeThenRead();
        new WriteReadSum().sumPerLine();//using BufferedReader
        new WriteReadSum().totalSum();//using BufferedReader
        new WriteReadSum().sumPerLine2();//using Scanner
        new WriteReadSum().totalSum2();//using Scanner
    }

    String fileName = "IntegerSum.txt";

    private void writeThenRead() throws IOException {
        FileWriter writer;
        char[] n = new char[50];
        FileReader reader;

        try {
            writer = new FileWriter(fileName);
            writer.write("5\n13\n240\n02\n2016\n1199\n50\n80000");
            writer.flush();
            writer.close();

            reader = new FileReader(fileName);
            reader.read(n);
            System.out.println(n);
            reader.close();
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //using BufferedReader
    private void sumPerLine() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                int i = Integer.parseInt(line);
                int sum = 0;//if this is kept out of the while loop, then it sums each line consecutively
                while (i > 0) {
                    sum = sum + i % 10;
                    i = i / 10;
                }
                System.out.println(sum);
            }
            reader.close();
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private void totalSum() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                int i = Integer.parseInt(line);
                sum += i;
            }
            System.out.println(sum);
            System.out.println("");
            reader.close();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    //using scanner
    private void sumPerLine2() throws IOException {
        try {
            int integer, digit;
            char digitAt;
            String StringNum;
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                int sum = 0;//if this is kept out of the while loop, then it sums each line consecutively
                //String StringNum;
                integer = scanner.nextInt();
                StringNum = String.valueOf(integer);

                for (int count = 0; count < StringNum.length(); count++) {
                    digitAt = StringNum.charAt(count);
                    digit = Character.getNumericValue(digitAt);
                    sum += digit;
                }
                System.out.println(sum);
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private void totalSum2() throws IOException {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}


