import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while(true){
            int n = sc.nextInt();
            if (n == 0) break;
            list.add(n);
        }

        for (int n : list){
            int count =0;
            for (int i = n+1 ; i <= 2 * n; i++){
                if (isPrime(i)) count++;}
                System.out.println(count);
        }

    }
    private static boolean isPrime (int num){
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}
