package org.example;

import java.util.Scanner;

public class Main {
    static int row = 7;
    static int column = 8;
    static char[][] room = new char[row][column];

    public static void main(String[] args) {
        initializeRoom();
        printSeats();
        createNewRoom();
    }

    public static void initializeRoom(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                room[i][j] = 'S';
            }
        }
    }

    public static void printSeats(){
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < row; i++) {
            StringBuilder linesS = new StringBuilder(i + 1 + " ");
            for (int j = 0; j < column; j++) {
                String available = room[i][j] + " ";
                linesS.append(available);
            }
            System.out.println(linesS);
        }
    }

    public static void createNewRoom(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Now lets add another room to the cinema.");
        System.out.println("Enter the number of rows:");
        int numRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numColumn = scanner.nextInt();

        int profit = calculateProfit(numRow, numColumn);
        System.out.println("Total income:\n$" + profit);
    }

    public static int calculateProfit(int numRows, int numColumns){
        int profit;
        int priceFirstRow = 10;
        int priceLastRow = 8;
        int totalSeats = numRows * numColumns;
        if (totalSeats <= 60){
            profit = totalSeats * priceFirstRow;
        } else {
            profit = ((numRows / 2) * numColumns) * priceFirstRow;

            if (numRows % 2 != 0){
                profit += ((numRows - (numRows / 2)) * numColumns) * priceLastRow;
            } else {
                profit += ((numRows / 2) * numColumns) * priceLastRow;
            }
        }

        return profit;
    }
}