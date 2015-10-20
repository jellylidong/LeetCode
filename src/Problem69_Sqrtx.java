

public class Problem69_Sqrtx {
	public int mySqrt(int x) {
        if(x <= 1)
            return x;
        int left = 1;
        int right = x;
        int res = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid < x/mid){
                left = mid+1;
                res = mid;//very import!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
            else if(mid == x/mid)
                return mid;
            else
                right = mid-1;
        }
        return res;
    }
}

//consider bit manipulation, this is easier to avoid boundary problems
