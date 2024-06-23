package Recursion;

import java.util.*;

public class matchingParen {
    public List<String> generateMatchParen(int n) {
        List<String> result = new ArrayList<>();
        generate(0,0,"",result, n);
        return result;
    }

    public void generate(int left, int right, String cur, List<String> res, int count) {
        if(cur.length() == count*2) {
            res.add(cur);
            return;
        }
        if(left < count) {
            generate(left+1, right, cur+ "(", null, count);
        }

        if(right <left) {
            generate(left, right+1, cur+ ")", null, count);
        }
    }
    
}
