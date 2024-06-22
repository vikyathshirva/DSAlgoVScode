package Backtracking;
import java.util.*;


public class generateSubsets {

    public List<List<Integer>>  generate(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(res,0,nums,cur);
        return res;
    }


    public void backtrack(List<List<Integer>> ans, int idx, int[] nums, List<Integer> cur) {
        if(idx == nums.length-1) {
            ans.add(new ArrayList<>(cur));
        }
        cur.add(nums[idx]);
        backtrack(ans, idx+1, nums, cur);
        cur.remove(cur.size()-1);
        backtrack(ans, idx+1, nums, cur);
    }

    
}
