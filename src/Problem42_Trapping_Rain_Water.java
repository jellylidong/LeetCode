
public class Problem42_Trapping_Rain_Water {
	public int trap(int[] height) {
        int curmaxid = 0;
        int premaxid = 0;
        int black = 0, white = 0;
        int l = height.length;
        if(l == 0)
            return 0;
        for(int i = 0; i < l; i++){
            if(height[i] >= height[curmaxid]){
                premaxid = curmaxid;
                curmaxid = i;
            }
            black += height[i];
            if( i != curmaxid){
                if(height[i] > height[curmaxid])
                    white += (height[i] - height[curmaxid]) * i;
            }
            else
                white += (height[curmaxid] - height[premaxid]) * i;
            
        }
        int maxid = curmaxid;
        curmaxid = l-1;
        premaxid = l-1;
        for(int i = l-1; i >= maxid; i--){
            if(height[i] >= height[curmaxid]){
                premaxid = curmaxid;
                curmaxid = i;
            }
            if( i != curmaxid){
                if(height[i] > height[curmaxid])
                    white += (height[i] - height[curmaxid]) * (l - i - 1);
            }
            else
                white += (height[curmaxid] - height[premaxid]) * (l - i - 1);
        }
        
        
        int total = l * height[maxid];
        int blue = total - black - white;
        return blue;
    }
}
