package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking method as generating binary bit words
 * 2^n
 *
 * b[i]=1
 * backtrack
 * b[i]=0
 * backtrack
 *
 * hits the end of the size and adds whatever is left in the temp storage
 *
 *
 * TC---O(n2^n)
 * since we spend O(n) time for each set ; it has about 2^n subsets
 *
 */
public class PowerSet {


    public List<List<Integer>> allPowerSet(List<Integer> nums){
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrack(int i, List<Integer> nums, ArrayList<Integer> soFar, List<List<Integer>> ans) {
        if( i == nums.size()-1){
            ans.add(new ArrayList<>(soFar));
            return;
        }else{
            soFar.add(nums.get(i));
            backtrack(i+1,nums,soFar,ans);
            soFar.remove(soFar.size()-1);
            backtrack(i+1,nums,soFar,ans);
        }
    }

    public List<List<Integer>> generatePowerSet(List<Integer> inputSet){
        List<List<Integer>> powerset = new ArrayList<>();
        for( int i=0;i<(1 << inputSet.size());i++){
            int bitArr = i;
            List<Integer> subset = new ArrayList<>();
            while(bitArr != 0){
                subset.add(inputSet.get((int)(Math.log(bitArr &~(bitArr-1))/Math.log(2))));
                bitArr &= bitArr-1;
            }
            powerset.add(subset);
        }
        return powerset;
    }

}
