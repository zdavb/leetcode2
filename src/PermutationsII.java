import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dave on 2015/10/13.
 */
public class PermutationsII {

    HashSet<String> sets;

    private void dfs(List<List<Integer>> res,List<Integer> tmplist,List<Integer> remainlist){
        int size = tmplist.size();
        if(remainlist.size()==0){
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i<size;i++){
                int val = tmplist.get(i);
                builder.append(val);
                builder.append('&');
            }
            String s = builder.toString();
            if(!sets.contains(s)){
                res.add(new ArrayList<>(tmplist));
                sets.add(s);
            }
            return;
        }
        for(int i = 0;i<remainlist.size();i++){
            int val = remainlist.get(i);
            remainlist.remove((int)i);
            tmplist.add(val);
            dfs(res,tmplist,remainlist);
            remainlist.add(i,val);
            tmplist.remove(tmplist.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        sets = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        List<Integer> remainlist = new LinkedList<>();

        for(int i = 0;i<nums.length;i++){
            remainlist.add(nums[i]);
        }
        dfs(res,tmplist,remainlist);
        return res;
    }
    public void test(){
        System.out.println(permuteUnique(new int[]{3,3,0,0,2,3,2,4}));
    }
}
