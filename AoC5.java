package advent6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dfiga
 */
public class AoC5 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader data = new BufferedReader(new FileReader("C:\\Users\\dfiga\\Documents\\NetBeansProjects\\advent6\\src\\advent6\\input.txt"));

        String line;
        int[][] twoD = new int[1000][1000];
        int answer = 0;

        while ((line = data.readLine()) != null) {
            String[] testLine = line.split(" -> ");

            String output1 = testLine[0];
            String output = testLine[1];
            String[] outputArr1 = output.split(",");
            String[] outputArr = output1.split(",");

            int x1 = Integer.parseInt(outputArr[0]);
            int y1 = Integer.parseInt(outputArr[1]);

            int x2 = Integer.parseInt(outputArr1[0]);
            int y2 = Integer.parseInt(outputArr1[1]);

            if (x1 < x2 && y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    twoD[y1][i]++;
                }
            } else if (x1 > x2 && y1 == y2) {
                for (int i = x2; i <= x1; i++) {
                    twoD[y1][i]++;
                }
            } else if (x1 == x2 && y1 > y2) {
                for (int j = y2; j <= y1; j++) {
                    twoD[j][x1]++;
                }

            } else if (x1 == x2 && y1 < y2) {
                for (int j = y1; j <= y2; j++) {
                    twoD[j][x1]++;
                }
            } else if (x1 > x2 && y1 < y2) {
                for (int i = x2; i <= x1; i++) {
                    twoD[y2][i]++;
                    if (y2 > y1) {
                        y2--;
                    }
                }
            } else if (x1 < x2 && y1 < y2) {
                for (int i = y1; i <= y2; i++) {
                    twoD[x1][i]++;
                    if (x1 < x2) {
                        x1++;
                    }
                }
            } else if (x1 > x2 && y1 > y2) {
                for (int i = x1; i >= x2; i--) {
                    twoD[y1][i]++;
                    if (y1 > y2) {
                        y1--;
                    }
                }
            } else if (x1 < x2 && y1 > y2) {
                for (int i = x1; i <= x2; i++) {
                    twoD[y1][i]++;
                    if (y1 > y2) {
                        y1--;
                    }
                }
            }

        }

        for (int j = 0; j < twoD.length; j++) {
            for (int i = 0; i < twoD[0].length; i++) {
                if (twoD[j][i] >= 2) {
                    answer++;
                }
                System.out.print(twoD[j][i]);
            }
            System.out.println("");
        }
        System.out.println(answer);
    }
}
