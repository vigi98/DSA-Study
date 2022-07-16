import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
    
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }

  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    
      if(unique.length()==idx){
        //getNo1:- better
        int sn3 = getNo2(s3,charIntMap);
        int sn1 = getNo2(s1,charIntMap);
        if(sn1>sn3) return;
        int sn2 = getNo2(s2,charIntMap);

        if(sn1+sn2==sn3)
        {
         display1(unique,charIntMap);//better
         //display2(unique,charIntMap);
        }    
        
        return;
      }

      char cur=unique.charAt(idx);

      for(int i=0;i<=9;i++){
        if(usedNumbers[i]) continue;
        
        charIntMap.put(cur,i);
        usedNumbers[i]=true;
        solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
        usedNumbers[i]=false;
        charIntMap.put(cur,-1);
      }


  }

  static int getNo1(String s,HashMap<Character, Integer> charIntMap ){
   
   int no=0;
   int len=s.length();
   for(int i=0;i<len;i++){
     char ch=s.charAt(i);
     no=no*10+charIntMap.get(ch);
   }
   return no;
  }

  static int getNo2(String s,HashMap<Character, Integer> charIntMap ){
   
   String num="";
    int len=s.length();
   for(int i=0;i<len;i++){
     num+=charIntMap.get(s.charAt(i));
   }

   return Integer.parseInt(num);
  }

  static void display1(String unique,HashMap<Character, Integer> charIntMap){

    char[]carr=unique.toCharArray();
    Arrays.sort(carr);
    for(char ch: carr){
      int v = charIntMap.get(ch);
      System.out.print(ch+"-"+v+" ");
    }
    System.out.println();

  }

  static void display2(String unique,HashMap<Character, Integer> charIntMap){

    for(int i=0;i<26;i++){
      char ch=(char)('a'+i);
      if(charIntMap.containsKey(ch))
       System.out.print(ch+"-"+charIntMap.get(ch)+" ");
    }

    System.out.println();

  }


}
