import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i =2; i<=n; i++){
            if (n%i==0){
                if (isPrime(i)){
                    n /= i;
                    System.out.println(i);
                    i--;
                }
            }
        }

    }
    public static boolean isPrime(int n){
        if (n<2) return false;
        for (int i=2; i*i<=n; i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
