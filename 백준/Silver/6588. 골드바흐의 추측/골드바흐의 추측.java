import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean[] prime = new boolean[1000001]; // 마지막 0
    static boolean doit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (!doit) che();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean find = false;
            for (int i = 3; i <= n / 2; i += 2) {
                if (prime[i] && prime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    find = true;
                    break;
                }
            }

            if (!find) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }

    }

    // 소수 배열 초기화
    public static void che() {
        doit = true; // che를 한번만 호출하기 위함
        prime[0] = prime[1] = false; // 0,1은 소수아님
        for (int i = 2; i <= 1000000; i++)
            prime[i] = true;
        for (int i = 2; i < 1000000; i++) {
            if (!prime[i]) continue; // prime[i] 소수아니면 걍 진행하고,
            for (int j = 2 * i; j <= 1000000; j += i) {
                prime[j] = false;    //소수인 숫자의 배수들은 전부 소수가 아님
            }
        }
    }
}
