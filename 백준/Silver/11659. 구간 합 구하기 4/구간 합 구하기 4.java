import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] prefix = new int[N + 1];

        for(int i=1;i<=N;i++){
            prefix[i] = prefix[i-1] + sc.nextInt();
        }
        
        for(int k=0;k<M;k++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(prefix[b] - prefix[a - 1]);
        }
    }
}