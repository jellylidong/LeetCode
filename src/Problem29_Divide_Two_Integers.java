
public class Problem29_Divide_Two_Integers {
	/*public static int divide(int dividend, int divisor) { // dividend beichushu, divisor chushu
		if(divisor == 0)
            return Integer.MAX_VALUE;
        if(dividend == 0)
            return 0;
		if(divisor == 1)
        	return dividend;
        if(divisor == -1)
        	return dividend == Integer.MIN_VALUE? Integer.MAX_VALUE: -dividend;
//        if(dividend == Integer.MIN_VALUE){
//        	if(divisor == Integer.MAX_VALUE)
//        		return -1;
//        	if(divisor == Integer.MIN_VALUE)
//        		return 1;
//        	else dividend++;
//        }
        if(divisor == Integer.MIN_VALUE){
        	if(dividend == Integer.MIN_VALUE)
        		return 1;
        	if(dividend > Integer.MIN_VALUE)
        		return 0;
   
        }
        if(divisor == Integer.MAX_VALUE){
        	if(dividend <= -Integer.MAX_VALUE)
        		return -1;
        	if(dividend == Integer.MAX_VALUE)
        		return 1;
        	else return 0;
        }
        if(dividend == Integer.MIN_VALUE){
        	
        	dividend >>= 1;
        	divisor >>= 1;
        }
        
		//System.out.println(dividend);
        
        int sign = sign(dividend, divisor);
        dividend = Math.abs(dividend);
        divisor  = Math.abs(divisor);
        //System.out.println(dividend + " " + divisor);
        
        int res = 0;
        //int tmp = divisor;
        while(dividend >= divisor){
            int count = 0;
            while(dividend - (divisor<<count) >= 0)
                count++;
            res += 1<<(count-1);
            dividend -= divisor<<(count-1);
        }
        return sign > 0?res:(0-res);
    }*/
	public static int divide(int dividend, int divisor) { // dividend beichushu, divisor chushu
	
	}
    public static int sign(int a, int b){
        return (a < 0 && b < 0) || (a > 0 && b >0) ? 1:-1;
    }
    
    public static void main(String[]  args){
    	System.out.println("aaa");
    	//System.out.println(Integer.MAX_VALUE);
    	System.out.println(divide(-2147483648, 3));
    	//System.out.println(divide(26, 8));
    }
}
