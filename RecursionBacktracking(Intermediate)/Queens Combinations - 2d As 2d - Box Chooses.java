import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
       
    //    if(qpsf==tq){
    //        System.out.println(asf);
    //        return;
    //    }

       //all boxes visited
       if(row==tq){
            if(qpsf==tq){
                  System.out.println(asf);
           return;
       }
         return;
       }
        
       String slc="",nslc="";
       if(col==tq-1){
           
           row++;
           col=0;
           slc=asf+"q\n";
           nslc=asf+"-\n";

       }else{
           
           col++;
           slc=asf+"q";
           nslc=asf+"-";
       
       }

       queensCombinations(qpsf+1,tq,row,col,slc);
       queensCombinations(qpsf,tq,row,col,nslc);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}