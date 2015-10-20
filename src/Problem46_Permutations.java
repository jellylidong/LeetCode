import java.util.*;
public class Problem46_Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new  ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
       if(nums.length == 0){
           return lists;
       }
       if(nums.length >= 1){
           list.add(nums[0]);
           lists.add(list);
       }
       for(int i = 1; i < nums.length; i++){
           List<List<Integer>> newlists = new ArrayList<List<Integer>>();
           List<Integer> newlist = new ArrayList<Integer>();
           for(List<Integer> ele : lists){
               for(int j = 0; j <= ele.size(); j++){
                   newlist =  new ArrayList<Integer>(insert(j, ele, nums[i]));
                   newlists.add(newlist);
               }
           }
           lists = new ArrayList<List<Integer>>(newlists);
       }
       return lists;
   }
   
   private List<Integer> insert(int i, List<Integer> list, int num){
       List<Integer> newlist = new ArrayList<Integer>(list);
       if(i < list.size())
           newlist.add(i,num);
       else
           newlist.add(num);
       return newlist;
   }
}
