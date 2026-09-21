class Solution {
    public int solution(int n) {
        // 홀수인 경우 채울 수 없음
        if (n % 2 != 0) return 0;
        
        long[] dp = new long[n + 1];
        int MOD = 1_000_000_007;

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            // 점화식: f(i) = 4 * f(i-2) - f(i-4)
            // 음수 방지를 위해 MOD를 더한 후 나눕니다.
            dp[i] = (dp[i - 2] * 4 - dp[i - 4] + MOD) % MOD;
        }

        return (int) dp[n];
    }
}