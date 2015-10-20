
public class Problem151_Reverse_Words_in_a_String {
	public static void main(String []args){
        //System.out.println(convertToTitle(1));
        System.out.println(reverseWords( " "));
     }
	//exceed memory limit
	/*
     public static String reverseWords(String s) {
        int i = 0;
        for(; i < s.length(); i++){
            if(s.charAt(i) == ' ')
            	break;
        }
        return i == s.length()? s: reverseWords(s.substring(i+1, s.length())) + " " + s.substring(0,i);
    }*/
	
//	public static String reverseWords(String s) {
//        int count = 0;
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == ' ')
//                count++;
//        }
//        int end = s.length();
//        while(count > 0){
//            for(int i = 0; i < end; i++){
//                if(s.charAt(i) == ' '){
//                    String s1 = s.substring(0, i);
//                    String s2 = s.substring(i+1, end);
//                    String s3 = "";
//                    if(end != s.length())
//                    	s3 = s.substring(end, s.length());
//                    int offset = s1.length();
//                    end = end - (offset+1);
//                    s = s2 + " " + s1 + "" + s3;
//                    count--;
//                    break;
//                }
//            }
//        }
//        return s;
//    }
	public static String reverseWords(String s) {
		String[] part = s.trim().split("\\s+");
		StringBuilder res = new StringBuilder();
		for(int i  = part.length-1; i >0; i--){
			res.append(part[i]+" ");
		}
		res.append(part[0]);
		return res.toString();
	}
}
