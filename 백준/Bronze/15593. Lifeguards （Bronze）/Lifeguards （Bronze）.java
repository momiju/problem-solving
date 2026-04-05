import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] start = new int[N];
        int[] end = new int[N];
        
        for (int i = 0; i < N; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        
        int maxTime = 0;
        
        for(int fire=0;fire<N;fire++){
            boolean[] work = new boolean[1001];
            
            for(int i=0;i<N;i++){
                if(i==fire) continue;
                
                for(int t=start[i];t<end[i];t++){
                    work[t] = true;
                }
            }
            // 현재 해고 경우에서 총 커버 시간 계산
            int total = 0;
            for(int t=0;t<1000;t++){
                if(work[t]) total++;
            }
            
            maxTime = Math.max(maxTime, total);
        }
        System.out.print(maxTime);
    }
}