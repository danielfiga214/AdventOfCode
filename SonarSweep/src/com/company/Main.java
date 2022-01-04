package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

class Run {

    static final String inputFile = "C:\\Users\\dfiga\\IdeaProjects\\SonarSweep\\src\\input.txt";

    static private void partOne() throws FileNotFoundException {

        Integer prev = null;
        int counter = 0;


            File sweepdata = new File(inputFile);
            Scanner reader = new Scanner(sweepdata);
            while (reader.hasNextLine()) {
                int depth = Integer.parseInt(reader.nextLine());
                if (prev != null && depth > prev)
                    counter++;
                prev = depth;
            }
            reader.close();
    }

    static private void partTwo(int slidingWindowSize) throws FileNotFoundException {

        Integer prev = null;
        int counter = 0;

        Integer slidingWindowSum = 0;
        ArrayDeque<Integer> slidingWindow = new ArrayDeque<>();


            File myObj = new File(inputFile);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                int depth = Integer.parseInt(reader.nextLine());

                slidingWindow.add(depth);
                slidingWindowSum += depth;

                if (slidingWindow.size() > slidingWindowSize) {
                    slidingWindowSum -= slidingWindow.pop();
                    if (prev < slidingWindowSum)
                        counter++;
                }
                prev = slidingWindowSum;
            }
            reader.close();
            System.out.println(counter);
    }

    public static void main(String[] args) throws FileNotFoundException {
        partOne();
        partTwo(1);
        partTwo(3);
    }

}

