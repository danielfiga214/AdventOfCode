package com.company;

import bingo.BingoBoard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\dfiga\\IdeaProjects\\GiantSquid\\src\\com\\company\\input.txt"));

            List<BingoBoard> boards = new ArrayList<>();

            int lineNum = 0;
            String numbers = "";
            BingoBoard currentBoard = null;
            String line;
            while ((line = br.readLine()) != null) {
                if (lineNum == 0) {
                    numbers = line;
                    lineNum++;
                    continue;
                }
                if (line.isBlank()) {
                    if (currentBoard != null) {
                        boards.add(currentBoard);
                    }
                    currentBoard = new BingoBoard();
                    continue;
                }

                assert currentBoard != null;
                currentBoard.addLine(line);

                lineNum++;
            }

            if (currentBoard != null) {
                boards.add(currentBoard);
            }

            BingoBoard winningBoard = null;
            int winningNum = 0;
            int numOfWinningBoards = 0;
            for (String num : numbers.split(",")) {
                int numInt = Integer.parseInt(num);
                for (BingoBoard b : boards) {
                    if (b.addNum(numInt)) {
                        winningBoard = b;
                        winningNum = numInt;
                        numOfWinningBoards++;
                        if (numOfWinningBoards == boards.size()) {
                            break;
                        }
                        /*System.out.println("first part = " + b.calcWinningBoard(numInt));
                        exit(0);*/
                    }
                }
            }
            if (winningBoard != null) {
                System.out.println("second part = " + winningBoard.calcWinningBoard(winningNum));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

