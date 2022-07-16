import java.io.*;
import java.util.*;

public class Main {

    private static int maxScore=0;
	public static void solution(String[] words, int[] farr, int[] score, int idx,int curS) {
		
		if(idx==words.length)
		 {
			 maxScore=Math.max(maxScore,curS);
			 return;
		 }

		//Not including

		solution(words,farr,score,idx+1,curS);

		//including word

		
		String word = words[idx];
        boolean check=true;
		int selScore = 0,selAns=0;

		//check if alpha are available
		for(int i=0;i<word.length();i++){
			char ch= word.charAt(i);
			if(farr[ch -'a']==0)
			{
				check=false;
			}

            farr[ch-'a']--;
			selScore+=score[ch-'a']; 
		}

         // if frequency is fine then include
		if(check){
			//setting maxScore before include
		    maxScore=Math.max(maxScore,curS);
			solution(words,farr,score,idx+1,curS+selScore);
		}

        //backtracking frequency array
		for(int i=0;i<word.length();i++){
          char ch = word.charAt(i);
		  farr[ch-'a']++;
		}

		// return Math.max(selAns,nselAns);
        
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		solution(words, farr, score, 0,0);
		System.out.println(maxScore);

	}
}