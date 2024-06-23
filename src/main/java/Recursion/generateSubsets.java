package Recursion;

import java.util.*;

public class generateSubsets {

    public List<String> generateSubsetsOfString(String s) {
        List<String> result= new ArrayList<>();
        generate(0,s, result, "");
        return result;
    }


    public void generate(int idx,String s, List<String> res, String cur) {
        if(idx == s.length()) {
           res.add(cur);
           return;
        }
        generate(idx+1, s, res, cur+s.charAt(idx));
        generate(idx+1, s, res, cur);
    }

    
}
