// import java.io.*;
import java.util.*;

public class Crossword {

  public static void solution(char[][] arr, String[] words, int vidx) {
    
    if(vidx==words.length)
    {
      print(arr);
      return;
    }
    
    String word=words[vidx];

    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){

        if(arr[i][j]=='-'|| arr[i][j]==word.charAt(0)){

          if(canPlaceHorizontal(i,j,word,arr)){
              // System.out.println(i+","+j+",H");
             boolean[] setChars = placeHorizontal(i,j,word,arr);
             solution(arr,words,vidx+1);
             unplaceHorizontal(i,j,arr,setChars);
          }

          if(canPlaceVertical(i,j,word,arr)){
              // System.out.println(i+","+j+",V");
             boolean[] setChars = placeVertical(i,j,word,arr);
             solution(arr,words,vidx+1);
             unplaceVertical(i,j,arr,setChars);
          }
        }
      }
    }
  }

  static boolean canPlaceHorizontal(int i,int j,String w,char[][]arr){
    
    if(j-1>=0 && arr[i][j-1]!='+') 
      return false;
    
    if((j+w.length()-1)>=arr[0].length)
     return false;

    if(j+w.length()<arr[0].length && arr[i][j+w.length()]!='+')
      return false;
    
    for(int jj=0; jj<w.length();jj++){
      
      char ch=w.charAt(jj);
      char arrChar=arr[i][j+jj];

      if(arrChar=='-' ||arrChar==ch) 
        continue;
      else
       return false;

    }

    return true;
  }

  static boolean canPlaceVertical(int i,int j,String w,char[][]arr){
    
    if(i-1>=0 && arr[i-1][j]!='+') 
      return false;
    
    if((i+w.length()-1)>=arr.length)
     return false;

    if(i+w.length()<arr.length && arr[i+w.length()][j]!='+')
      return false;
    
    for(int ii=0; ii<w.length();ii++){
      
      char ch=w.charAt(ii);
      char arrChar=arr[i+ii][j];
      
      if(arrChar=='-' ||arrChar==ch) 
        continue;
      else
       return false;

    }

    return true;


  }

  static boolean[] placeHorizontal(int i,int j,String w,char[][]arr){
    
    int len=w.length();
    boolean[]setChars= new boolean[len];

    for(int jj=0;jj<len;jj++){

      if(arr[i][j+jj]!='-'){
        setChars[jj]=false;
        continue;
      }

      setChars[jj]=true;
      arr[i][j+jj]=w.charAt(jj);

    }

    return setChars;
  }

  static boolean[] placeVertical(int i,int j,String w,char[][]arr){
    
    int len=w.length();
    boolean[]setChars= new boolean[len];

    for(int ii=0;ii<len;ii++){

      if(arr[i+ii][j]!='-'){
        setChars[ii]=false;
        continue;
      }

      setChars[ii]=true;
      arr[i+ii][j]=w.charAt(ii);

    }

    return setChars;
  }

  static void unplaceHorizontal(int i,int j, char[][]arr,boolean[]setChars){
    
    int len=setChars.length;

    for(int jj=0;jj<len;jj++){
      if(setChars[jj]){
        arr[i][j+jj]='-';
        continue;
      }
    }
  }

  static void unplaceVertical(int i,int j, char[][]arr,boolean[]setChars){
    
    int len=setChars.length;
    
    for(int ii=0;ii<len;ii++){
      if(setChars[ii]){
        arr[i+ii][j]='-';
        continue;
      }
    }
  }


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}