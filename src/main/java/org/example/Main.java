package org.example;

public class Main {
    static int row = 7;
    static int column = 8;
    static char[][] room = new char[row][column];

    public static void main(String[] args) {
        initializeRoom();
        printSeats();
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
}