package DSA_LoveBabbar.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class ratInAMaze {

    // RAT IN A MAZE

    /*

    Given a binary matrix maze[][] of size n × n containing values 0 and 1, find all possible paths for a rat to travel from the source cell (0, 0) to the destination cell (n - 1, n - 1). The rat can move in four directions: up(U), down(D), left(L), and right(R).

1 represents an open cell through which the rat can move.
0 represents a blocked cell that cannot be traversed.
The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

Note: Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

Examples:

Input: maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
Output: ["DDRDRR", "DRDDRR"]
Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Constraints:
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1



     */

    static boolean isSafeToMove(int newX, int newY,int n, int[][] maze, boolean[][] visited){

        if(newX < 0 || newX > n-1 || newY < 0 || newY > n-1){
            return false;
        }
        // blocked cell condition
        else if (maze[newX][newY] == 0) {
            return false;
        }
        // already visited cell
        else if (visited[newX][newY]) {
            return false;
        }else {
            return true;
        }
    }

    static void solve(int[][] maze, int srcX, int srcY, int destX, int destY, boolean[][] visited, ArrayList<String> ans, String path){

        // base case
        if(srcX == destX && srcY == destY){
            ans.add(path);
            return;
        }

        int n = maze.length;
        visited[srcX][srcY] = true;

        //Up
        int newX = srcX-1;
        int newY = srcY;
        if(isSafeToMove(newX,newY,n,maze,visited)){
            solve(maze,newX,newY,destX,destY,visited,ans,path+"U");
        }

        //Down
        newX = srcX+1;
        newY = srcY;
        if(isSafeToMove(newX,newY,n,maze,visited)){
            solve(maze,newX,newY,destX,destY,visited,ans,path+"D");
        }

        //Left
        newX = srcX;
        newY = srcY-1;
        if(isSafeToMove(newX,newY,n,maze,visited)){
            solve(maze,newX,newY,destX,destY,visited,ans,path+"L");
        }

        //Right
        newX = srcX;
        newY = srcY+1;
        if(isSafeToMove(newX,newY,n,maze,visited)){
            solve(maze,newX,newY,destX,destY,visited,ans,path+"R");
        }

        //Backtrack
        visited[srcX][srcY] = false;
    }

    static ArrayList<String> ratInMaze(int[][] maze){

        int srcX = 0;
        int srcY = 0;

        int n = maze.length;
        int destX = n-1;
        int destY = n-1;

        boolean[][] visited = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        String path = "";

        // agar starting point agar block cell hua toh i.e. [0][0] == 0, ya phir destination cell
        if(maze[0][0]  == 0 || maze[n-1][n-1] == 0){
            return ans;
        }

        solve(maze,srcX,srcY,destX,destY,visited,ans,path);
        Collections.sort(ans);
        return ans;
    }

    static void main() {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ArrayList<String> result = ratInMaze(maze);
        System.out.print("All valid path: "+result);
    }
}
