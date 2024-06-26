package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> combination(int n , int k){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k,1,new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int offset, List<Integer> partialCombination, List<List<Integer>> result) {
        if(partialCombination.size() == k){
            result.add(new ArrayList<>(partialCombination));
            return;
        }

        final int numRemaining = k - partialCombination.size();
        for(int i=offset;i<=n && numRemaining <= n-i+1 ;i++){
            partialCombination.add(i);
            System.out.println(i);
            backtrack(n,k,i+1,partialCombination,result);
            partialCombination.remove(partialCombination.size()-1);
        }

    }


}
