
public class Problem66_Plus_One {
	public int[] plusOne(int[] digits) {
        int sum = 0;
        int carry = 1;
        int l = digits.length;
        for(int i  = l - 1; i >= 0; i--){
            int tmp = digits[i] + carry;
            sum = tmp%10;
            carry = tmp/10;
            digits[i] = sum;
            if(i == 0 && carry != 0){
                digits = expand(digits, carry);
                //return result;
            }
        }
        return digits;
    }
    
    private int[] expand(int[] digits, int carry){
        int[] result = new int[digits.length+1];
        for(int i  = 1; i < result.length; i++)
            result[i] = digits[i-1];
        result[0] = carry;
        return result;
    }
}
