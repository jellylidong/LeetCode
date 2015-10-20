//import java.awt.List;
import java.util.*;

public class Problem60_Permutation_Sequence {
	//this method works fine, but exceed time limit
	/*
	public static String getPermutation(int n, int k) {
        int limit = 1;
        String begin = "";
        for(int i =1; i <= n; i++){
            limit *= i;
            begin += String.valueOf(i);
        }
        if(k > limit)
        		return "";
        String res = begin;
        for(int i = 2; i <=k; i++){
            res = nextP(res);
        }
        return res;
        
    }
    
    public static String nextP(String str){
        char[] ss = str.toCharArray();
        int i = ss.length-1;
        for(; i >= 0; i--){
            if(i == 0)
                return str;
            if(ss[i-1] < ss[i])
                break;
        }
        
        int id1 = i-1;
        int id2 = i;
        for(int j = id2; j < ss.length; j++){
            if(ss[j] < ss[id2] && ss[j] > ss[id1])
                id2 = j;
        }
        char tmp = ss[id1];
        ss[id1] = ss[id2];
        ss[id2] = tmp;
        Arrays.sort(ss, id1+1, ss.length);
        return String.valueOf(ss);
        
    }*/
	
	public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(String.valueOf(i));
        return P(list, k);
    }
    
    public static int orderMul(int n){
        int i = 1;
        while(n > 0)
            i *= n--;
        return i;
    }
    
    public static String P(List<String> list, int k){
        int n = list.size();
        if(n > 0){
            if(n == 1)
            return list.get(0);
            int limit = orderMul(n-1);
            int count = 1;
            int up = limit;
            while(up < k){
                count++;
                up = count*limit;
            }
            if(limit == k){
            	
            }
            String begin = list.get(count-1);
            list.remove(count-1); 
            
            return begin + P(list, k-limit*(count-1));
        }
        return "";
    }
    
    public static void main(String[] args){
    	System.out.println(getPermutation(2, 1));
    }
}
