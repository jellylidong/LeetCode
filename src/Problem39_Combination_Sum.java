import java.util.*;
public class Problem39_Combination_Sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(0);
        int id = 0;
        Arrays.sort(candidates);
        
        if(candidates.length == 1 && candidates[0] > target)
        	return lists;
        while(candidates[id] <= 0){
        	id++;
        	if(id == candidates.length)
        		break;
        }
        if(candidates[id] == 0)
        	return lists;
        backtrack(id, candidates, sum, target, lists, list);
        return lists;
    }
    
    private static void backtrack(int start, int[] candidates, List<Integer> sum, int target, 
    											List<List<Integer>> lists, List<Integer> list){
        for(int i = start; i < candidates.length; i++){
            //List<Integer> list = new AarryList<Integer>();
            list.add(candidates[i]);
            int tmp = sum.get(0);
           // if(i != start)
            //	tmp -= candidates[i-1];
            sum.set(0, tmp + candidates[i]);
            tmp = sum.get(0);
         
            if(sum.get(0) < target)
                backtrack(i, candidates, sum, target, lists, list);
            else if(sum.get(0) == target){
                //tmp = tmp -candidates[i];
                //sum.set(0, tmp);
                //sum -= candidates[i-1];
            	List<Integer> newlist = new ArrayList<Integer>();
                for(int n: list)
                    newlist.add(n);
                lists.add(newlist);
                int size = list.size();
            	tmp -= list.get(size-1);
                list.remove(size - 1);
            	sum.set(0,  tmp);
                if(list.size() > 0){
                	tmp -= list.get(size-2);
                	sum.set(0,  tmp);
                    list.remove(size - 2);
                }
                break;
            }
            else if(sum.get(0) > target){
            	//tmp = tmp -candidates[i];
                //sum.set(0, tmp);
            	int size = list.size();
            	tmp -= list.get(size-1);
                list.remove(size - 1);
            	sum.set(0,  tmp);
                if(list.size() > 0){
                	tmp -= list.get(size-2);
                	sum.set(0,  tmp);
                    list.remove(size - 2);
                }
                break;
            }
            int s = list.size();
            if(s >= 1 && i == candidates.length-1)
            	list.remove(s-1);
            sum.set(0, tmp - candidates[i]);
        }
    }
    
    public static void main(String[] args){
    	int[] candidates = {1,2,3,4};
    	System.out.println("aaa");
    	int target = 4;
    	List<List<Integer>> lists = combinationSum(candidates, target);
    	tools.print2dList(lists);
    }
}
