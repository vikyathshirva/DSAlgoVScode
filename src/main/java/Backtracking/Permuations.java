package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permuations {
    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack2(0,list,nums);
        return list;
    }




    private void backtrack2(int i, List<List<Integer>> list , List<Integer> nums ){
        if(i ==  nums.size()-1){
            list.add(new ArrayList<>(nums));
            return;
        }else{
            for(int j=i;j<nums.size();j++){
                Collections.swap(nums,i,j);
                backtrack2(i+1,list,nums);
                Collections.swap(nums,i,j);
            }
        }

    }



}
