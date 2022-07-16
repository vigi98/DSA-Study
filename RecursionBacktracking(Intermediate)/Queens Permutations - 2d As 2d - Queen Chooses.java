import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        
        if(tq==qpsf){
            for(int[]col:chess){
                for(int e:col){
                    if(e==0)
                      System.out.print("-\t");
                    else
                      System.out.print("q"+e+"\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int r=0;r<chess.length;r++){
            for(int c=0;c<chess[0].length;c++){
                if(chess[r][c]==0){
                    chess[r][c]=qpsf+1;
                    queensPermutations(qpsf+1,tq,chess);
                    chess[r][c]=0;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}