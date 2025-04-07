package university.management.system;

import java.util.*;

public class TicTacToeClass {
    private final int[][] board;
    private final Map<String, int[]> moveMap;

    public TicTacToeClass() {
        board = new int[3][3]; // 0 = empty, 1 = player, 2 = AI
        moveMap = new HashMap<>();
        initializeMoveMap();
    }

    private void initializeMoveMap() {
        moveMap.put("A1", new int[]{0, 0});
        moveMap.put("A2", new int[]{0, 1});
        moveMap.put("A3", new int[]{0, 2});
        moveMap.put("B1", new int[]{1, 0});
        moveMap.put("B2", new int[]{1, 1});
        moveMap.put("B3", new int[]{1, 2});
        moveMap.put("C1", new int[]{2, 0});
        moveMap.put("C2", new int[]{2, 1});
        moveMap.put("C3", new int[]{2, 2});
    }

    public int getSquare(String square) {
        int[] pos = moveMap.get(square);
        return (pos != null) ? board[pos[0]][pos[1]] : -1;
    }

    public void playMove(String square, int player) {
        int[] pos = moveMap.get(square);
        if (pos != null && board[pos[0]][pos[1]] == 0) {
            board[pos[0]][pos[1]] = player;
        }
    }

    public int isGameOver() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        
        for (int[] row : board)
            for (int cell : row)
                if (cell == 0)
                    return 0;
        
        return 3; // Tie
    }

    public String getNextMove() {
        for (String key : moveMap.keySet()) {
            int[] pos = moveMap.get(key);
            if (board[pos[0]][pos[1]] == 0)
                return key;
        }
        return null;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], 0);
        }
    }
}
