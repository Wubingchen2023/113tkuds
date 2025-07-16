import java.util.Scanner;

class TicTacToe5x5 {
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final int BOARD_SIZE = 5; // 將棋盤大小設為 5

    /**
     * 初始化 5x5 的井字遊戲棋盤
     */
    static char[][] initializeBoard() {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }

        return board;
    }

    /**
     * 列印棋盤，包含行列座標
     */
    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.print("  ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < BOARD_SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 放置棋子
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        // 檢查座標是否有效
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }

        // 檢查該位置是否已被佔用
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }

        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    /**
     * 檢查是否有玩家獲勝（連成 5 個相同符號）
     */
    static char checkWinner(char[][] board) {
        // 檢查行
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col <= BOARD_SIZE - 5; col++) {
                if (board[row][col] != EMPTY &&
                    board[row][col] == board[row][col+1] &&
                    board[row][col+1] == board[row][col+2] &&
                    board[row][col+2] == board[row][col+3] &&
                    board[row][col+3] == board[row][col+4]) {
                    return board[row][col];
                }
            }
        }

        // 檢查列
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row <= BOARD_SIZE - 5; row++) {
                if (board[row][col] != EMPTY &&
                    board[row][col] == board[row+1][col] &&
                    board[row+1][col] == board[row+2][col] &&
                    board[row+2][col] == board[row+3][col] &&
                    board[row+3][col] == board[row+4][col]) {
                    return board[row][col];
                }
            }
        }

        // 檢查主對角線 (\)
        for (int row = 0; row <= BOARD_SIZE - 5; row++) {
            for (int col = 0; col <= BOARD_SIZE - 5; col++) {
                if (board[row][col] != EMPTY &&
                    board[row][col] == board[row+1][col+1] &&
                    board[row+1][col+1] == board[row+2][col+2] &&
                    board[row+2][col+2] == board[row+3][col+3] &&
                    board[row+3][col+3] == board[row+4][col+4]) {
                    return board[row][col];
                }
            }
        }

        // 檢查反對角線 (/)
        for (int row = 0; row <= BOARD_SIZE - 5; row++) {
            for (int col = 4; col < BOARD_SIZE; col++) { // 從右邊開始檢查
                if (board[row][col] != EMPTY &&
                    board[row][col] == board[row+1][col-1] &&
                    board[row+1][col-1] == board[row+2][col-2] &&
                    board[row+2][col-2] == board[row+3][col-3] &&
                    board[row+3][col-3] == board[row+4][col-4]) {
                    return board[row][col];
                }
            }
        }

        return EMPTY;  // 沒有獲勝者
    }

    /**
     * 檢查棋盤是否已滿
     */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = initializeBoard();
        Scanner sc = new Scanner(System.in);
        char currentPlayer = PLAYER_X; // 預設 X 先手

        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard(board);

        while (true) {
            System.out.printf("玩家 %c 請輸入落子座標 (row col, 例如: 0 0): ", currentPlayer);
            int row, col;

            try {
                row = sc.nextInt();
                col = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("輸入格式錯誤，請輸入兩個整數！");
                sc.next(); // 消費掉錯誤的輸入
                sc.next();
                continue; // 重新開始此回合
            }

            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);

                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("平手！");
                    break;
                }

                // 切換玩家
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        sc.close();
    }
}