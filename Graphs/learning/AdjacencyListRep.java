 package Graphs.learning;

 import java.util.ArrayList;

 public  class AdjacencyListRep {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 5;

        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(2).add(5);
        adj.get(5).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);
        for(int i=0;i<n+1;i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }
}