import java.util.*;
public class Problem115_Distinct_Subsequences {
	public static int numDistinct(String s, String t) {
        //String newS = s;//sortStr(s);
        //String newT = t;//sortStr(t);
        List<String> listS = genSub(s);
        //List<String> listT = genSub(t);
        //tools.printList(listS);
        System.out.println();
        //tools.printList(listT);
        System.out.println();
        int count = 0;
        for(String ss: listS){
            if(!isSub(ss, t)){
                count++;
                System.out.print(ss+" ");
            }
        }
//        for(String tt: listT){
//            if(!isSub(tt, s))
//                count++;
//        }
        return count;
    }
    
    public static List<String> genSub(String str){
        List<String> list = new ArrayList<String>();
        String tmp = "";
        list.add(tmp);
        for(int i = 0 ; i < str.length(); i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                String tmp1 = list.get(j);
                String tmp2 = Character.toString(str.charAt(i));
                list.add(tmp1 + tmp2);
            }
        }
        return list;
    }
    
    public static boolean isSub(String str, String S){
    	if(str.length() > S.length())
    		return false;
    	int ids = 0;
    	int idS = 0;
    	while(idS < S.length() && ids < str.length()){
    		if(str.charAt(ids) == S.charAt(idS))
    			ids++;
    		idS++;
    	}
    	return ids == str.length();
    }
    
    public static void main(String[] args){
    	//String s= "anacondastreetracecar";
    	//String t = "contra";
    	String s ="rabbbit";
    	String t = "rabbit";
    	//String s = "ab";
    	//String t = "ba";
    	int res = numDistinct(s, t);
    	System.out.println(res);
    	//System.out.print(isSub("aqa","bbahca"));
    }
    
}
