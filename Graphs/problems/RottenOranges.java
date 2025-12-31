package Graphs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };

    int total = 0;
    public  int   bfs(int[][] grid , boolean[][] vis , int i , int j , int n , int m ){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        int min = 0;
        while (!q.isEmpty()){

            int sz = q.size();
            while (sz>0){
                int[] curr = q.poll();
                for(int d=0;d<directions.length;d++){
                    int newX = curr[0]+directions[d][0];
                    int newY = curr[1]+directions[d][1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY <m && grid[newX][newY] == 1  && !vis[newX][newY]){
                        vis[newX][newY] = true;
                        total++;
                        q.add(new int[]{newX , newY});

                    }
                }

                sz--;
            }
            min++;

        }
        return  min;
    }
    public int orangesRotting(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int cnt = 0;
       int min = 0;
       boolean vis[][] = new boolean[n][m];
       int unrotten = 0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j] == 1){
                   unrotten++;
               }
           }
       }
       for(int i=0;i<n;i++ ){
           for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                   vis[i][j] = true;
                   min += bfs(grid , vis , i , j , n , m );
               }

           }
       }
       if (total == unrotten){
           return  min;
       }
       return  -1;

    }

}
