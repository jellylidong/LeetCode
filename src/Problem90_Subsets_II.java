import java.util.*;
public class Problem90_Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        lists.add(list);
        for(int i  = 0; i < nums.length; i++){
            int size = lists.size();
            for(int j = 0; j < size; j++){
                List<Integer> tmp = new ArrayList<Integer>();
                copyList(tmp, lists.get(j));
                tmp.add(nums[i]);
                if(!lists.contains(tmp))
                    lists.add(tmp);
            }
        }
        return lists;
    }
    
    private void copyList(List<Integer> dest, List<Integer> source){
        for(int n: source)
            dest.add(n);
    }
}
