package DynamicProgramming.SubsequencesOrSubstrings;

public class maxProductSubArray {

    public int max(int[] nums) {
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int max = 0;
        for(int i=1;i<nums.length;i++) {
            int copyMax = maxSoFar;
            int el = nums[i];
            maxSoFar = Math.max(el* maxSoFar, el* minSoFar);
            minSoFar = Math.min(el* copyMax, el* minSoFar);

            max = Math.max(maxSoFar, minSoFar);
        }

        return max;
    }
    
}