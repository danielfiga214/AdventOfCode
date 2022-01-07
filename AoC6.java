package advent6;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author dfiga
 */
public class AoC6 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dfiga\\Documents\\NetBeansProjects\\advent6\\src\\advent6\\input.txt"));
        String[] input = br.readLine().split(",");

        long[] fishAge = new long[9];

//        long fish0 = 0;
//        long fish1 = 0;
//        long fish2 = 0;
//        long fish3 = 0;
//        long fish4 = 0;
//        long fish5 = 0;
//        long fish6 = 0;
//        long fish7 = 0;
//        long fish8 = 0;
        long day = 0;

        for (String fish : input) {
            int longAge = Integer.parseInt(fish);
            fishAge[longAge]++;
        }

        for (int j = 0; j < 256; j++) {
            day++;
            long[] temp = new long[9];
            for (int k = 0; k < fishAge.length; k++) {
                temp[k] = fishAge[k];
            }
            for (int l = 0; l < fishAge.length - 1; l++) {
                fishAge[l] = temp[l + 1];
            }
            fishAge[6] += temp[0];
            fishAge[8] = temp[0];
        }

//        for (int j = 0; j < 256; j++) {
//            day++;
//            long fish8b = 0;
//            long fish6b = 0;
//            for (int k = 0; k <= 9; k++) {
//                if (fishAge[0] > 0) {
//                    fish8b += fishAge[0];
//                    fish6b += fishAge[0];
//                }
//                fishAge[k] ++;
//                fishAge[9] = 0;
//                fish0 = fish1;
//                fish1 = fish2;
//                fish2 = fish3;
//                fish3 = fish4;
//                fish4 = fish5;
//                fish5 = fish6;
//                fish6 = fish7;
//                fish7 = fish8;
//                fish8 = 0;
//        fishAge[6] += fish6b;
//        fishAge[8] += fish8b;
            long totalCount = 0;
            for (int i = 0; i < fishAge.length; i++) {
                totalCount += fishAge[i];
            }
            System.out.println("After  " + day + "  days: " + totalCount);
    }
}

//long totalCount = fish0 + fish1 + fish2 + fish3 + fish4 + fish5 + fish6 + fish7 + fish8;


