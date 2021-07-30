package com.coding.kakao2021.summer;

public class Test2_other {
    boolean keepDistance = true;
    int startRow;
    int startCol;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i=0; i<places.length; i++) {
            keepDistance = true;
            char[][] room = new char[5][5];

            for(int j=0; j<room.length; j++) {
                for(int k=0; k<room[j].length; k++)
                    room[j][k] = places[i][j].charAt(k);
            }

            check(room);

            if(keepDistance)
                answer[i] = 1;
        }

        return answer;
    }

    public void check(char[][] room) {
        for(int i=0; i<room.length; i++) {
            for(int j=0; j<room[i].length; j++) {
                char current = room[i][j];

                if(current == 'P' && keepDistance) {
                    startRow = i;
                    startCol = j;
                    dfs(room, i, j, 0);
                }
            }
        }
    }

    public void dfs(char[][] room, int row, int col, int depth) {
        if(depth <= 2 && keepDistance) {
            if(room[row][col] == 'P' && depth >= 1) {
                keepDistance = false;
                return;
            }

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] direction : directions) {
                int movedRow = row + direction[0];
                int movedCol = col + direction[1];

                if(movedRow == startRow && movedCol == startCol)
                    continue;

                if (canMove(room, movedRow, movedCol))
                    dfs(room, movedRow, movedCol, depth + 1);
            }
        }
    }

    public boolean canMove(char[][] room, int movedRow, int movedCol) {
        if(movedRow >= 0 && movedRow < room.length && movedCol >=0 && movedCol < room[0].length) {
            return room[movedRow][movedCol] != 'X';
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
