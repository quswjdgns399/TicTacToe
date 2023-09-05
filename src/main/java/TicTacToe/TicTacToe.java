package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    static String[] board;
    static Scanner sc;

    static int inputCount = 0;
    static final int maxInput = 9;

    public static void resetBoard() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static void inputX() {
        sc = new Scanner(System.in);
        System.out.printf("[X의 순서] X를 놓을 번호를 고르세요 >> ");
        int inputPositionX = sc.nextInt();

        if (board[inputPositionX - 1].equals("O") || board[inputPositionX - 1].equals("X")) {
            System.out.println("이미 놓인 곳입니다. 다른 위치를 선택해주세요");
            inputX();
        } else {
            board[inputPositionX - 1] = "X";
            inputCount++;
            printBoard();
        }

    }

    public static void inputO() {
        sc = new Scanner(System.in);
        System.out.printf("[O의 순서] O를 놓을 번호를 고르세요 >> ");
        int inputPositionY = sc.nextInt();

        if (board[inputPositionY - 1].equals("X") || board[inputPositionY - 1].equals("O")) {
            System.out.println("이미 놓인 곳입니다. 다른 위치를 선택해주세요");
            inputO();
        } else {
            board[inputPositionY - 1] = "O";
            inputCount++;
            printBoard();
        }
    }

    public static String checkWin() {
        for (int[] win : winingstatus) {
            String position1 = board[win[0]];
            String position2 = board[win[1]];
            String position3 = board[win[2]];

            if (position1.equals(position2) && position2.equals(position3)) {
                if (!position1.equals(String.valueOf(win[0] + 1))) {
                    return position1;
                }
            }
        }

        return "";
    }

    private static final int[][] winingstatus = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
    };


    public static void main(String[] args) {

        resetBoard();
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();


        String winner = "";

        while (true) {
            inputX();
            winner = checkWin();
            if (!winner.isEmpty()) {
                System.out.println(winner + "가 이겼습니다!");
                break;
            } else if (inputCount == maxInput) {
                System.out.println("비겼습니다!");
                break;
            }

            inputO();
            winner = checkWin();
            if (!winner.isEmpty()) {
                System.out.println(winner + "가 이겼습니다!");
                break;
            } else if (inputCount == maxInput) {
                System.out.println("비겼습니다!");
                break;
            }
        }

    }
}
