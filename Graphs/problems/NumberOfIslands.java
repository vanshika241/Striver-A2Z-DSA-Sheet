package Graphs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };
    public  void  bfs(char[][] grid , boolean[][] vis , int i , int j , int n , int m){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});

        while (!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<directions.length;d++){
                int newX = curr[0]+directions[d][0];
                int newY = curr[1]+directions[d][1];
                if(newX >= 0 && newX < n && newY >= 0 && newY <m && grid[newX][newY] == '1' && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    q.add(new int[]{newX , newY});
                }
            }
        }
    }
    public  void  dfs(char[][] grid , boolean[][] vis , int i , int j , int n , int m){
        vis[i][j] = true;
        for(int d=0;d<directions.length;d++){
            int newX = i+directions[d][0];
            int newY = j+directions[d][1];
            if(newX >= 0 && newX < n && newY >= 0 && newY <m && grid[newX][newY] == '1' && !vis[newX][newY]){
                vis[newX][newY] = true;
                dfs(grid , vis , newX , newY , n , m);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == '1' && !vis[i][j]){
                    cnt++;
                    vis[i][j] = true;
                    bfs(grid , vis , i , j , n , m );

                }
            }
        }
        return cnt;
    }
}
