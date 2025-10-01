import java.util.Scanner;

public class Main {
    static int n;
    static int s;
    static int[] numbers;
    static int total = 0;
    public static void main(String[] args){
             Scanner sc = new Scanner(System.in);
             n = sc.nextInt();
             s = sc.nextInt();

             numbers = new int[n];

             int number;
             for(int i = 0; i < n; i++){
                 number = sc.nextInt();
                 numbers[i] = number;
             }
             subset(0,0);
             if (s==0)
                 System.out.println(total-1);
             else
                 System.out.println(total);
    }

      public static void subset(int idx, int sum){
        if (idx == n){
            if (sum == s) total++;
            return;
        }

        // 현재 idx번째 수 포함
          subset(idx+1, sum+numbers[idx]);
        //포함안함
          subset(idx+1, sum);

//        if (cnt == n) {
//            int sum =0;
//            for (int i=0; i<n; i++){
//                if (visited[i])
//                    sum += numbers[i];
//            }
//            if (sum == s) total++;
//            return;
//        }
//        visited[cnt] = true;
//        subset(cnt+1, visited);
//        visited[cnt] = false;
//        subset(cnt+1, visited);
    }
}
