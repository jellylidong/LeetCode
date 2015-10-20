//import java.util.*;
public class Problem204_Count_Primes {
	//poor run time
	/*
	List<Integer> res = new ArrayList<>();
    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        for(int i = 2; i < n; i++){
            if(i <= 3)
                res.add(i);
            
            else if(i%2 != 0){
                if(isP(i)){
                    res.add(i);
                }
            }
        }
        return res.size();
    }
    
    public boolean isP(int n){
        for(int i = 1; i < res.size(); i++){
            int num = res.get(i);
            if(num*num > n)
                return true;
            if(n % num == 0)
                return false;
        }
        return true;
    }*/
	
	 public static int countPrimes(int n) {
	        boolean[] res = new boolean[n];
//	        for(boolean b: res)
//	        	System.out.println(b+" ");
	        //mark non-prime as true; prime as false; because the initial value of boolean is false;
	        // so !res[i] means number i is a prime
	        if(n <= 2)
	        	return 0;
	        for(int i = 2; i < n; i++){
	            if(!res[i]){
	                int count = 2;
	                while(i*count < n){
	                    if(!res[i*count])
	                    	res[i*count] = true;
	                    //System.out.print(i*count + " ");
	                    count++;
	                    
	                }
	            }
	        }
	        int countP = 0;
	        for(int i = n-1; i >= 2; i--){
	            if(!res[i]){
	                countP++;
	                System.out.println(i);
	            }
	        }
	        return countP>0? countP: 0;
	    }
	 
	 public static void main(String[] args){
		 int res = countPrimes(0);
		 System.out.println(res);
	 }
}
