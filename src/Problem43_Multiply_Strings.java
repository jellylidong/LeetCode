
public class Problem43_Multiply_Strings {
	
	public static String add(String num1, String num2){
        String shortStr = num1.length() < num2.length() ? num1:num2;
        String longStr = num1.length() >=num2.length() ? num1:num2;
        int carry = 0;
        String resStr = "";
        
        int diff = longStr.length() - shortStr.length();
        //System.out.println(shortStr.charAt(0) + " " + longStr.charAt(0+diff));
        for(int i = shortStr.length()-1; i >= 0; i--){
            int v1 = shortStr.charAt(i) - 48;
            int v2 = longStr.charAt(i+diff) - 48;
            //System.out.println(v1+" "+v2+" "+carry);
            int sum = (v1+v2+carry)%10;
            carry = (v1+v2+carry)/10;
            //System.out.println(v1+" "+v2+" "+sum+" "+carry);
            resStr = Integer.toString(sum) + resStr;
        }
        for(int i = longStr.length()-1-shortStr.length(); i >= 0; i--){
            int v1 =longStr.charAt(i) - 48;
            int sum = (v1+carry)%10;
            carry=(v1+carry)/10;
            //System.out.println(v1+" "+sum+" "+carry);
            resStr = Integer.toString(sum) + resStr; 
        }
        if(carry != 0)
            resStr = Integer.toString(carry) + resStr; 
        return resStr;
    }
	
	public static String multiply(String num1, String num2){
		String res = "";
		for(int i = num1.length()-1; i >= 0; i--){
			String resS = "";
			int carry = 0;
			int sum   = 0;
			int v1 = num1.charAt(i)-48;
			for(int j = num2.length()-1; j >= 0; j--){
				int v2 = num2.charAt(j)-48;
				sum = (v1*v2+carry)%10;
				carry = (v1*v2+carry)/10;
				resS = Integer.toString(sum) + resS;
			}
			if(carry != 0)
				resS = Integer.toString(carry) + resS;
			for(int k = 0; k < num1.length()-i-1; k++)
				resS += "0";
			System.out.println(res);
			res = add(res, resS);
		}
		while(res.charAt(0) == '0' && res.length() > 1)
			res = res.substring(1);
		return res;
	}
	
	public static void main(String[] args){
		//String res = add("", "167");
		String res2= multiply("98", "9");
//		int v1 = ('0' - 48);
//		int v2 = ('6' - 48);
//		
//		System.out.println(v1*v2);
		//System.out.println(res);
		System.out.println(res2);
	}
}
