package org.example;

import java.util.Scanner;

public class Main {
    static int row = 7;
    static int column = 8;
    static char[][] room = new char[row][column];
    static int priceFirstRow = 10;
    static int priceLastRow = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        initializeRoom();
        do {
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    printSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Select one option from the menu!");
            }

        } while (option != 0);
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

    public static void buyTicket(){
        Scanner scanner = new Scanner(System.in);
        int ticketPrice = priceFirstRow;

        System.out.println("Lets proceed to buy a ticket, select the row you wish for:");
        int ticketRow = scanner.nextInt();
        System.out.println("Now the seat number:");
        int ticketColumn = scanner.nextInt();

        if( ticketRow >= ((row / 2) + 1)){
            ticketPrice = priceLastRow;
        }

        System.out.println("Ticket price: $" + ticketPrice);
        room[ticketRow - 1][ticketColumn - 1] = 'B';
        printSeats();

    }
}