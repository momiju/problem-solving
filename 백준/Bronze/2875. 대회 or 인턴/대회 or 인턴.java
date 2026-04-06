import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 여
        int M = sc.nextInt(); // 남
        int K = sc.nextInt(); // 인턴십
        int count = 0;
        
        for (int team=0;team<=100;team++) {
            if ((2*team <= N) && (team <= M) && (3*team <= N+M-K)) {
                count = team;
            }
        }
        System.out.println(count);
    }
}