import java.util.Scanner;

public class Main {
    static int n;
    static int m;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int g = g(n,m);
        int l = (n*m) / g;

        System.out.println(g);
        System.out.println(l);
    }

    // 최대 공약수
    public static int g(int n, int m){
        if (m == 0)
            return n;
        return g(m, n%m);
    }
}
