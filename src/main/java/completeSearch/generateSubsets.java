package completeSearch;
import java.util.*;


public class generateSubsets {

    private int n;
    private List<Integer> list;
    public generateSubsets(int n) {
        this.n = n;
        list = new ArrayList<>();
        new ArrayList<>();
    }

    public void search(int k) {
        if(k == n) {
            //process subset
        } else {
            search(k+1);
            list.add(k);
            search(k+1);
            list.remove(list.size()-1);
        }
    }

    // using bit manipulation
    // For example, the bit representation of 25 is 11001, which corresponds to the
    // subset {0,3,4}.
    public List<List<Integer>> generateAllSubset(int n)  {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<(1 << n);i++) {
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i & (1 << j)) != 0) {
                    sub.add(j);
                }
            }
            result.add(sub);
        }
        return result;
    }

    
}
