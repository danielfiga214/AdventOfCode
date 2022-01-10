/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advent6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dfiga
 */
public class Day7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dfiga\\Documents\\NetBeansProjects\\advent6\\src\\advent6\\input.txt"));
        String[] crabsPosition = br.readLine().split(",");

        int cheapestFuel = Integer.MAX_VALUE;
        int maxValue = 0;

        for (int i = 0; i < crabsPosition.length; i++) {
            int crabPosition = Integer.parseInt(crabsPosition[i]);
            if (crabPosition > maxValue) {
                maxValue = crabPosition;
            }
        }
        int maxValueB = maxValue;

        for (int i = 0; i < maxValue; i++) {
            int fuelBurnt = 0;

            for (int j = 0; j < crabsPosition.length; j++) {
                int currentBurnt = 0;
                int tmp = 0;
                int crabPosition = Integer.parseInt(crabsPosition[j]);
                if (crabPosition >= maxValueB) {
                    currentBurnt += crabPosition - maxValueB;
                    for (int k = 1; k < currentBurnt; k++) {
                        tmp += k;
                    }
                    fuelBurnt += currentBurnt + tmp;
                } else {
                    currentBurnt += maxValueB - crabPosition;
                    for (int k = 1; k < currentBurnt; k++) {
                        tmp += k;
                    }
                    fuelBurnt += currentBurnt + tmp;
                }
            }
            maxValueB--;
            if (fuelBurnt < cheapestFuel) {
                cheapestFuel = fuelBurnt;
            }

        }
        System.out.println("Total cost = " + cheapestFuel);
    }
}
