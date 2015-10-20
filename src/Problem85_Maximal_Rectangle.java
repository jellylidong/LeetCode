	
public class Problem85_Maximal_Rectangle {
//	int cmaxl = 0;
//    int cmaxh = 0;
//    public int maximalRectangle(char[][] matrix) {
//        if(matrix.length == 0 || matrix[0].length == 0)
//            return 0;
//        int l = matrix[0].length;
//        int h = matrix.length;
//        int res = 0;
//        point[][][] p = new point[h+1][l+1][2];
//        for(int i = 0; i < h+1; i++){
//            for(int j = 0; j < l+1; j++){
//                p[i][j][0] = new point(0,0);// 0 from up
//                p[i][j][1] = new point(0,0);// 1 from left
//            }
//        }
//        for(int i = 1; i < h+1; i++){
//            for(int j = 1; j < l+1; j++)
//                if(matrix[i-1][j-1] == '1'){
//                    if(p[i-1][j-1][0].equals(0,0) && !p[i-1][j][0].equals(0,0) && !p[i][j-1][0].equals(0,0)){
//                        p[i][j][0] = new point(p[i-1][j][0].x, p[i-1][j][0].y+1);
//                        p[i][j][1] = new point(p[i][j-1][1].x+1, p[i][j-1][1].x);
//                    }
//                    else{
//                        p[i][j][0] = p[i][j][1] = new point(p[i-1][j][0].x+1, p[i][j-1][1].y+1);
//                    }
//                    res = Math.max(res, p[i][j][0].area());
//                }
//        }
//        return res;
//    }
//    
//    public class point{
//        int x;
//        int y;
//        point(int xx, int yy){
//            x = xx;
//            y = yy;
//        }
//        public boolean equals(int xx, int yy){
//            return xx==x && yy==y;
//        }
//        public int area(){
//            return x*y;
//        }
//    }
	
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int d = matrix.length;
        int w = matrix[0].length;
        int[] left = new int[w];
        int[] right =new int[w];
        int[] height=new int[w];
        int area = 0;
        for(int i = 0; i < w; i++){
            left[i] = 0;
            right[i] = w;
            height[i]= 0;
        }
        for(int i = 0; i < d; i++){
            int curLeft = 0; 
            int curRight= w;
            for(int j = 0; j < w; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                    left[j] = Math.max(curLeft, left[j]);
                    //right[j] = Math.min(curRight, right[j]);
                }
                else{
                    height[j] = 0;
                    left[j] = 0; curLeft = j+1;
                    //right[j]= w; curRight=j; // ????
                }
                //area = Math.max(area, (right[j] - left[j])*height[j]);
            }
            for(int j = w-1; j >= 0; j--){
                if(matrix[i][j] == '1')
                    right[j] = Math.min(curRight, right[j]);
                else{
                    curRight = j; right[j] = w;
                }
            }
            
            for(int j = 0; j < w; j++)
                area = Math.max(area, (right[j] - left[j])*height[j]);
        }
        return area;
    }
}
