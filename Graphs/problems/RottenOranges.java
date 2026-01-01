package Graphs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    int[][] directions = {
            {-1, 0} , {1, 0} , {0,1} , {0,-1}
    };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int unrotten = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j] == 1 ){
                   unrotten++;
               }
               else if(grid[i][j] == 2){
                   q.add(new int[]{i , j , 0});
                   vis[i][j] = true;
               }
            }
        }
        int change = 0;
        int maxTime = 0;
        while (!q.isEmpty()){
            int curr[] = q.poll();
            for(int d  = 0;d<directions.length;d++){
                int newX = curr[0]+directions[d][0];
                int newY = curr[1]+directions[d][1];
                int time = curr[2];
                if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY] == 1 && !vis[newX][newY]){
                    change++;
                    q.add(new int[]{newX , newY , time+1});
                    maxTime = Math.max(maxTime , time+1);
                    vis[newX][newY] = true;
                }

            }
        }

        if(unrotten == change){
            return  maxTime;
        }
        return  -1;

    }

}
