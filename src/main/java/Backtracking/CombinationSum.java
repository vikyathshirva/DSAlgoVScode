package Backtracking;


import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> generateComSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result,target,0);
        return result;
    }

    private void backtrack(int[] nums,List<Integer> temp, List<List<Integer>> result, int target, int start) {
        if(target<0){return;}
        else if(target == 0) result.add(new ArrayList<>(temp));
        else{
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                backtrack(nums,temp,result,target-nums[i],i);
                temp.remove(temp.size()-1);
            }
        }

    }
}
