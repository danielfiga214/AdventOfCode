package advent6;

import java.io.BufferedReader;
import java.io.IOException;
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
        long totalCount = 0;
        for (int i = 0; i < fishAge.length; i++) {
            totalCount += fishAge[i];
        }
        System.out.println("After  " + day + "  days: " + totalCount);
    }
}
