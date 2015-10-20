import java.util.*;
public class Problem78_Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        lists.add(list);
        int length = nums.length;
        if(length == 0)
            return lists;
        Arrays.sort(nums);
        for(int i = 0; i < length; i++){
            int size = lists.size();
        	for(int j = 0; j < size; j++){
                List<Integer> tmp = new ArrayList<Integer>();
                List<Integer> ele = lists.get(j);
                for(int n: ele)
                    tmp.add(n);
                tmp.add(nums[i]);
                lists.add(tmp);
            }
        }
        return lists;
    }
	
	public static void main(String[] args){
		int[] nums = {1,2};
		List<List<Integer>> lists = subsets(nums);
		System.out.println(lists.size());
		tools.print2dList(subsets(nums));
	}
}
