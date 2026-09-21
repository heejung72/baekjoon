class Solution {
    public int solution(int[] nums) {
        int n = nums.length;

        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    boolean isPrime = true;     
                    
                    for (int m = 2; m < sum; m++) {
                        if (sum % m == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    
                    if (isPrime) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}