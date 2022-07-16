import java.io.*;
import java.util.*;

public class Main {

	
    static int count=1;
	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		
		if(i==n+1){
			if(rssf==k){
				System.out.print(count+". ");
				for(ArrayList<Integer>c:ans){
				    System.out.print(c+" ");	
				}
				count++;
				System.out.println();
			}
			return;
		}

		for(ArrayList<Integer>c:ans){

			if(c.size()==0){
				c.add(i);
				solution(i+1,n,k,rssf+1,ans);
				c.remove(new Integer(i));
				return;
			}

			c.add(i);
			solution(i+1,n,k,rssf,ans);
			c.remove(new Integer(i));
		
		}


		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}
