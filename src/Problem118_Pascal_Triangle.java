import java.util.*;
public class Problem118_Pascal_Triangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>> ();
        if(numRows == 0)
            return lists;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        lists.add(list);
        for(int i  = 0; i < numRows-1; i++){
            List<Integer> tmp = lists.get(i);
            List<Integer> newlist = new ArrayList<Integer>();
            for(int j = 0; j < tmp.size()+1; j++){
                if(j == 0 || j == tmp.size())
                    newlist.add(tmp.get(0));
                else
                    newlist.add(tmp.get(j-1) + tmp.get(j));
            }
            lists.add(newlist);
        }
        return lists;
    }
}
