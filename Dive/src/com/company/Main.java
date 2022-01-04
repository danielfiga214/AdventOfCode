package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dfiga\\IdeaProjects\\Dive\\src\\input.txt"));
            int depth = 0;
            int horizontal = 0;
            int aim = 0;

            String line;
            while ((line = br.readLine()) != null) {
                String[] arg = line.split(" ");
                String cmd = arg[0];
                int amount = Integer.parseInt(arg[1]);
                switch (cmd) {
                    case "forward":
                        horizontal += amount;
                        depth += aim * amount;
                        break;
                    case "down":
                        aim += amount;
                        break;
                    case "up":
                        aim -= amount;
                        break;
                }
            }

            System.out.println(depth * horizontal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
