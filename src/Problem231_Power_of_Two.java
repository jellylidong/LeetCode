
public class Problem231_Power_of_Two {
	public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        if(n <= 0 || n%2 == 1)
            return false;
        
        while(n != 2){
            n = n/2;
            if( n%2 == 1)
                return false;
        }
        return true;
    }
}
