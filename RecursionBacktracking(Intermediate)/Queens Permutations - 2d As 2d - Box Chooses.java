import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row==tq){
            if(qpsf==tq){
                System.out.println(asf+"\n");
            }
            return;
        }
         
        String nLine="";
        if(col==tq-1){
            row++;
            col=0;
            nLine="\n";
        }else{
            col++;
        }

        for(int i=0;i<tq;i++){
            if(!queens[i]){
                queens[i]=true;
                 queensPermutations(qpsf+1,tq,row,col,asf+"q"+(i+1)+"\t"+nLine,queens);
                queens[i]=false;
            }
        }

        queensPermutations(qpsf,tq,row,col,asf+"-\t"+nLine,queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}