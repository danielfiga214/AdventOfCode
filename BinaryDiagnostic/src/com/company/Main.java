package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

        public static String getValue(List<String> newData, String selectCritera, boolean keepMost) {
            int column = 0;

            while (newData.size() > 1) {
                int positive = 0;
                int negative = 0;

                for (String line : newData) {
                    String[] lineArr = line.split("");
                    String s = lineArr[column];
                    if (s.equals("1")) {
                        positive++;
                    } else {
                        negative++;
                    }
                }

                String keepCriteria = selectCritera;

                if (positive > negative) {
                    if (keepMost) {
                        keepCriteria = "1";
                    } else {
                        keepCriteria = "0";
                    }
                } else if (positive < negative) {
                    if (keepMost) {
                        keepCriteria = "0";
                    } else {
                        keepCriteria = "1";
                    }
                }

                List<String> keepList = new ArrayList<>();

                for (String line : newData) {
                    String[] lineArr = line.split("");
                    String val = lineArr[column];
                    if (val.equals(keepCriteria)) {
                        keepList.add(line);
                    }
                }
                newData = keepList;
                column++;
            }

            return newData.get(0);
        }

        public static void main(String[] args) {

            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dfiga\\IdeaProjects\\BinaryDiagnostic\\src\\input.txt"));

                List<String> newData = new ArrayList<>();

                String line;
                while ((line = br.readLine()) != null) {
                    newData.add(line);
                }

                String oxygenGenerator = getValue(newData, "1", true);
                String CO2Scrubber = getValue(newData, "0", false);

                BigInteger oxygenGeneratorNumber = new BigInteger(oxygenGenerator, 2);
                BigInteger CO2ScrubberNumber = new BigInteger(CO2Scrubber, 2);

                System.out.println(oxygenGeneratorNumber.intValue() * CO2ScrubberNumber.intValue());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}