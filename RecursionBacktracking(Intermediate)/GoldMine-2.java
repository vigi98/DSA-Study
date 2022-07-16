import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	public static void getMaxGold(int[][] arr){
	    
		int n=arr.length,m=arr[0].length;
		boolean[][]vis= new boolean[n][m];
		
		for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        if(!vis[i][j] && arr[i][j]!=0){
                  max=Math.max(max,findGold(i,j,arr,vis));
		        }
		    }
		}
		
	}
	
	static int findGold(int r,int c,int[][]arr,boolean[][]vis){
	    
	    if(r<0||r>=arr.length||c<0||c>=arr[0].length||arr[r][c]==0||vis[r][c])
	     return 0;
	     
	    vis[r][c]=true;
	    
	    return arr[r][c]+findGold(r-1,c,arr,vis)+findGold(r,c+1,arr,vis)+findGold(r+1,c,arr,vis)+findGold(r,c-1,arr,vis);
	    
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}