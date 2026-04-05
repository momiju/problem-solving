import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        boolean first = false;

        for(int x=-1000;x<=1000;x++){
            if(x*x + 2*A*x + B == 0){
                System.out.print(x);
                if (!first)
                    System.out.print(" ");
                first = true;
            }
        }
    }
}
