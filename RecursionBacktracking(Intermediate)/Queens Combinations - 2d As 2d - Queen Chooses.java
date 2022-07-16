import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int r, int col){
        
      if(qpsf==tq){
          for(int i=0;i<chess.length;i++){
             for(int j=0;j<chess[0].length;j++){
                 if(chess[i][j]){
                     System.out.print("q\t");
                 }else
                 System.out.print("-\t");
             }
             System.out.println();
          }
          System.out.println();
        return;
      }



      for(int i=r;i<chess.length;i++){
          for(int j=(i == r ? col+1:0);j<chess[0].length;j++){
              chess[i][j]=true;
              queensCombinations(qpsf+1,tq,chess,i,j);
              chess[i][j]=false;
          }
      }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}