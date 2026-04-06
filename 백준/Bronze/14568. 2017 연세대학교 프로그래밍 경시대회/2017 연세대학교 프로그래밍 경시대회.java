import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int A; // 택희
        int B; // 영훈
        int C; // 남규
        int count = 0;

        for (A = 2; A < N + 1; A += 2) {
            for (B = 1; B < N + 1; B++) {
                C = N - A - B;

                if (C <= 0)
                    continue;
                if (C >= B + 2)
                    count += 1;
            }
        }
        System.out.println(count);
    }
}