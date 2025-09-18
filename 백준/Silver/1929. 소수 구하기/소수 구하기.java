import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = n; i <= m; i++) {
            if (i == 1) continue;
            int isPrime = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j ==0){
                    isPrime = 1;
                    break;
                }
            }
            if (isPrime == 0) {
                System.out.println(i);
            }
        }
}
}
