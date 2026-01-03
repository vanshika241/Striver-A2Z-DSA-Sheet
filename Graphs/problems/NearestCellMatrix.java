package Graphs.problems;


import java.util.ArrayDeque;
import java.util.Queue;

public class NearestCellMatrix {

    int directions[][] = {
            {1,0} , {-1 , 0} , {0 , 1} , {0 , -1}
    };
//
//    public  int bfs(int mat[][] , int i , int j , int n , int m ){
//        boolean[][] vis = new boolean[n][m];
//        Queue<int[]> q = new ArrayDeque<>();
//        vis[i][j] = true;
//        q.add(new int[]{i , j , 0});
//        while (!q.isEmpty()){
//            int curr[] = q.poll();
//            for(int d  = 0;d<directions.length;d++){
//                int newX = curr[0]+directions[d][0];
//                int newY = curr[1]+directions[d][1];
//                int dist  = curr[2];
//                if(newX>=0 && newX<n && newY>=0 && newY<m && !vis[newX][newY]){
//                    if(mat[newX][newY] == 0){
//                        return  dist+1;
//                    }
//                    else{
//                        vis[newX][newY] = true;
//                        q.add(new int[]{newX , newY , dist+1});
//                    }
//                }
//
//            }
//        }
//        return  -1;
//    }
//    public int[][] updateMatrix(int[][] mat) {
//        int n = mat.length;
//        int m = mat[0].length;
//
//        int ans[][] = new int[n][m];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(mat[i][j] == 0){
//                    ans[i][j] = 0;
//                }
//                else{
//                    ans[i][j] = bfs(mat , i , j , n , m);
//                }
//
//            }
//        }
//        return  ans;
//
//    }


    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (mat[i][j] == 0){
                    q.add(new int[]{i , j , 0});
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()){
            int curr[] = q.poll();
            int dist = curr[2];
            int x = curr[0];
            int y = curr[1];
            ans[x][y] = dist;
            for(int d[] :directions){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && mat[nx][ny] == 1){
                    q.add(new int[]{nx , ny , dist+1});
                    vis[nx][ny] = true;
                }
            }

        }
        return  ans;

    }

}
