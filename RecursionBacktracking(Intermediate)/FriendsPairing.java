import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
  
   if(i==n+1)
   {
     System.out.println(counter+"."+asf);
     counter++;
     return;
   }

   if(used[i]){
     solution(i+1,n,used,asf);
   }else{
   //mark current used
   used[i]=true;
   //2 options-> not to pair or pair with any of unused number
   //not pair
   solution(i+1,n,used,asf+"("+i+") ");
   //pair
   for(int no=i+1;no<=n;no++){
     if(!used[no]){
      used[no]=true;
      solution(i+1,n,used,asf+"("+i+","+no+") ");
      used[no]=false;
     }
   }
   used[i]=false;
   }

  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}public class FriendsPairing {
    
}
