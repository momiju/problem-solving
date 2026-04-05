import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        
        for(int i=0;i<N;i++){
            arr[i] = sc.nextLong();
        }
        
        for(int j=0;j<N;j++){
            long c = arr[j];
		    boolean isKey = true;
            
            for(int k=2;k<=1000000;k++){
                if(c % k == 0){
                    isKey = false;
                    break;
                }
            }

            if(isKey)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}