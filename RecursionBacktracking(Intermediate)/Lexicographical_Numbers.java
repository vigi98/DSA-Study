import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here

		for(int i=1;i<=9 && i<=n;i++){
			dfs(i,n);
		}
	}

	static void dfs(int k,int n){

		System.out.println(k);
		
		for(int j=0;j<=9;j++){	
			//creating no
		   int no=k*10+j;
		   //check
		   if(no>n) 
		      return;//can also give break
           //if no valid then call 'no' family
		   dfs(no,n);
		}
	}
	
}