import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) {
                int option = dp[i / 2] + 1;
                if (option < dp[i]) dp[i] = option;
            }

            if(i % 3 == 0) {
                int option = dp[i / 3] + 1;
                if (option < dp[i]) dp[i] = option;
            }
        }
        System.out.println(dp[N]);
    }
}