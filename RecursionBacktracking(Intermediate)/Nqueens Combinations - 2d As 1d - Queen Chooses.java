import java.io.*;
import java.util.*;

public class Main {

   public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // vertical
        for (int i = row, j = col; i >= 0; i--) {
            if(chess[i][j]){
                return false;
            }
        }

        // horizontal
        for (int i = row, j = col; j >= 0; j--) {
            if(chess[i][j]){
                return false;
            }
        }

        // diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(chess[i][j]){
                return false;
            }
        }

        // anti-diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if(chess[i][j]){
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
        // nqueens2(chess,0);
    }

    static void nqueens2(boolean[][]chess,int row){

        if(row==chess.length){
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

        for(int col=0;col<chess[0].length;col++){
            if(isQueenSafe2(chess,row,col)){
                chess[row][col]=true;
                nqueens2(chess,row+1);                                
                chess[row][col]=false;
            }
        }
    }

    public static boolean isQueenSafe2(boolean[][] chess, int row, int col) {
        
        int k=1;
        for(int r=row-1;r>=0;r--){
            
         //top
         if(chess[r][col])
          return false;
         
         //left
         if(col-k>=0&& chess[r][col-k])
          return false;

         //right
         if(col+k<chess[0].length && chess[r][col+k])
             return false;
            
         k++;

        }

        return true;
    }
}