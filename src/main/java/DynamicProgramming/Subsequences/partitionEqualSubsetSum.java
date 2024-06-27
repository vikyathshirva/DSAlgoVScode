package DynamicProgramming.Subsequences;

public class partitionEqualSubsetSum {


    public boolean canPartition(int[] nums) {
        int curSum = 0;
        for(int n : nums) {
            curSum+=n;
        }

        if(curSum %2 != 0) {
            return false;
        }

        return partitionEqualSubsetSum(nums, curSum);
    }


    public boolean partitionEqualSubsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean [][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for(int i=1;i<n;i++) {
            for(int j=1;j<=target;j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= target) {
                    take = dp[i-1][j-nums[i]];
                }
                dp[i][j] = take ||notTake;
            }
        }

        return dp[n-1][target];
        
    }
    
    
}
