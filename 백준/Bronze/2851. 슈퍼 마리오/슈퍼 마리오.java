import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0; //누적합
        int best = 0; //현재까지 나온 누적합 중 최적값
        int[] m = new int[10];
        
        for(int i=0;i<10;i++){
            m[i] = sc.nextInt();
            sum += m[i];
            
            if(Math.abs(100-sum) < Math.abs(100-best))
                best = sum;
            else if(Math.abs(100-sum) == Math.abs(100-best) && (sum>best))
                best = sum;
        }
        System.out.println(best);
    }
}
