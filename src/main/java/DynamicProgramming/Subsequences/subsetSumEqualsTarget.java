package DynamicProgramming.Subsequences;

public class subsetSumEqualsTarget {


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


    


        return false;


    }
    
}
