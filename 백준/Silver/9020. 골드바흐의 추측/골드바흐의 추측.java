import java.util.Scanner;

public class Main {
    static int[] m;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = new int[n];

        for (int i =0; i<n; i++){
            m[i] = sc.nextInt();
            primeSum(m[i]);
        }

    }

    public static void primeSum(int m){
        int a = 0; int b = 0;

        for (int i = 2; i<= m/2; i++){
            int j = m - i;
            if (isPrime(i) && isPrime(j)){
                a = i;
                b = j;
            }
        }
        System.out.println(a+" "+b);
    }

    public static boolean isPrime(int m){
        if (m < 2) return false;
        for (int j = 2; j*j <=m; j++){
            if (m % j == 0){
                return false;
            }
        }
        return true;
    }
}
