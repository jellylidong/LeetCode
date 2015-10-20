import java.util.*;
public class Problem120_Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null)
            return 0;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(triangle.get(0));
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> cur = triangle.get(i);
            int size = cur.size();
            
            List<Integer> list = new ArrayList<Integer>(cur);
            //Collections.copy(list, cur);  
            List<Integer> pre = lists.get(i-1);
            
            for(int j = 0; j < cur.size()-1; j++){
                
                int tmp = Integer.MAX_VALUE;
                if(j > 0)
                    tmp = list.get(j);
                    
                int res1 = Math.min(tmp, cur.get(j) + pre.get(j));
                int res2 = cur.get(j+1)+pre.get(j);
                list.set(j, res1);
                list.set(j+1,res2);
                System.out.println(i+ " " +j+ " tmp="+tmp + " cur.get(j)=" + cur.get(j) + " pre.get(j) "+pre.get(j));
                tools.printList(list);
                System.out.println();
            }
        lists.add(list);
            
        }
        //tools.print2dList(lists);
        int h = triangle.size()-1;
        return findMin(lists.get(h));
    }
    
    private static int findMin(List<Integer> list){
        int min = Integer.MAX_VALUE;
        for(int n: list){
            if(n < min)
                min = n;
        }
        return min;
    }
    
    public static void main(String[] args){
    	int[][] arr = {{-1},{3,2},{1,-2,-1}};
    	List<List<Integer>> triangle = tools.gen2dList(arr);
    	int res = minimumTotal(triangle);
    }
}
