package DynamicProgramming.SubsequencesOrSubstrings;

import java.util.*;

public class subsetSumEqualsTarget {

    /**
     * 
     * Recursive solution.
     * 
     * time complexity is O(2^n) beacuse we have 2 branches at each state
     * space compleixty is O(n) stack space of the calls.
     */
    public boolean equalsOrNot(int[] nums, int target) {
        return helperRecur(nums, target, nums.length-1);
    }

    public boolean helperRecur(int[] nums, int target, int idx) {
        if(target == 0) {
            return true;
        }

        if(idx == 0) {
            return nums[idx] == target;
        }
        boolean notConsider = helperRecur(nums, target, idx-1);
        boolean considering = false;
        if(target >= nums[idx]) {
            considering = helperRecur(nums, target-nums[idx], idx-1);
        }
        //we just need one posssiblity that it can be done .
        return considering || notConsider;
    }


   /**
    * if they give a constainst we should have our dp array be as big as the constrainst +1
    */ 
    public boolean equalsOrNotMEM(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target+1];
        for(boolean[] dpRow : dp) {
            Arrays.fill(dpRow, false);
        }

        dp[0][nums[0]] = true;
        return helperRecurMEM(nums, target, nums.length-1, dp);
    }
    public boolean helperRecurMEM(int[] nums, int target, int idx, boolean[][] dp) {
        if(target == 0) {
            return true;
        }

        if(idx == 0) {
            return nums[idx] == target;
        }

        if(!dp[idx][target]) {
            return dp[idx][target];
        }
        boolean notConsider = helperRecurMEM(nums, target, idx-1, dp);
        boolean considering = false;
        if(target >= nums[idx]) {
            considering = helperRecurMEM(nums, target-nums[idx], idx-1,dp);
        }
        //we just need one posssiblity that it can be done .
        dp[idx][target] = considering || notConsider;
        return dp[idx][target];
    }


    //Bottom up approach
    public boolean subSetSum(int n,  int k, int[] nums) {
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int i=1;i<n;i++) {
            for(int j=1;j<=k;j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= k ) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        return dp[n-1][k];
    }


    //Bottom up approach Space Optimised
    // time is till O(n*K)
    // space is now O(k)
    public boolean subSetSumSO(int n,  int k, int[] nums) {
        boolean [] prev= new boolean[k+1];
        boolean [] cur= new boolean[k+1];
        prev[0] = true;
        cur[0] = true;
        prev[nums[0]] = true;
        for(int i=1;i<n;i++) {
            for(int j=1;j<=k;j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if(nums[i] <= k ) {
                    take = prev[j - nums[i]];
                }
                cur[j] = take || notTake;
            }
            prev = cur;
        }
        return prev[k];
    }


    
    
}
