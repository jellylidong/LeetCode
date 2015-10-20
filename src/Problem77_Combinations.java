import java.util.*;
public class Problem77_Combinations {
	public class Solution {
	    public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        if(k == n || k == 0){
	            List<Integer> list = new ArrayList<Integer>();
	            for(int i  = 1; i <= k; i++){
	                list.add(i);
	            }
	            lists.add(list);
	            return lists;
	        }
	        
	        lists = combine(n-1, k-1);
	        lists.forEach(e -> e.add(n)); // this sentence is only surpported by java 1.8 or higher
	        lists.addAll(combine(n-1, k));
	        return lists;
	    }
	    
	    /*
	        //this solution has wrong index, not passed and too complex!
	        List<List<List<Integer>>> whole = new ArrayList<List<List<Integer>>>();
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        
	        for(int i  = 1 ; i <= n; i++){
	            List<Integer> list = new ArrayList<Integer>();
	            list.add(i);
	            lists.add(list);
	            //lists.add(list);
	        }
	        whole.add(lists);
	        whole.add(lists);
	        if(k >= n)
	            return whole.get(0);
	        for(int i = 2; i <= k; i++){
	            List<List<Integer>> tmplists = whole.get(i-1);
	            List<List<Integer>> newlists = new ArrayList<List<Integer>>();
	            int start = 1;
	            for(int j = 0; j < tmplists.size(); j++){
	                List<Integer> tmplist = tmplists.get(j);
	                
	                for(int m = start; m <= n; m++){
	                    if(!tmplist.contains(m)){
	                        List<Integer> newlist = tmplist;
	                        newlist.add(m);
	                        newlists.add(newlist);
	                    }
	                }
	                start++;
	            }
	            
	            whole.add(newlists);
	        }
	        return whole.get(k);*/
	}
}
