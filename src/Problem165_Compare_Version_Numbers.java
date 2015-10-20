import java.util.*;
// very poor run time
// consider use String.split()
public class Problem165_Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
        List<Integer> list1 = split(version1);
        List<Integer> list2 = split(version2);
        int i = 0;
        while(i < list1.size() && i < list2.size()){
            int v1 = list1.get(i);
            int v2 = list2.get(i);
            if(v1 > v2) return 1;
            if(v1 < v2) return -1;
            i++;
        }
        
        if(i >= list1.size()){
            while(i < list2.size()){
                int v2 = list2.get(i);
                if(v2 != 0) return -1;
                i++;
            }
        }
        else if(i >= list2.size()){
            while(i < list1.size()){
                int v1 = list1.get(i);
                if(v1 != 0) return 1;
                i++;
            }
        }
        return 0;
        
    }
    
    public List<Integer> split(String s){
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int id = 0;
        while(id < s.length()){
            if(s.charAt(id) == '.'){
                String tmp = s.substring(start, id);
                list.add(Integer.parseInt(tmp));
                start = id+1;
            }
            id++;
        }
        String tmp = s.substring(start, id);
        list.add(Integer.parseInt(tmp));
        return list;
    }
}
