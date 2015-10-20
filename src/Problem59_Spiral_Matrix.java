
public class Problem59_Spiral_Matrix {
	public static int[][] generateMatrix(int n) {
		if(n == 0){
            int[][] spiral = new int[0][0];
            return spiral;
        }
		int[][] spiral = new int[n][n];
        int[] vec = genVec(n);
        tools.printArray(vec);
        int row = 0, col = 0;
        int count = 1;
        for(int i  = 0; i < vec.length; i++){
            for(int j = 0; j < vec[i]; j++){
                
                spiral[row][col] = count;
                count++;
                switch(i%4){
                    case 0: col++; break;
                    case 1: row++; break;
                    case 2: col--; break;
                    case 3: row--; break;
                }
            }
        }
        spiral[row][col] = count;
        return spiral;
    }
    
    private static int[] genVec(int n){
        int[] vec = new int[2*n - 1];
        vec[0] = n-1;
        int count = 1;
        for(int i = 1; i < 2*n-1; i+=2){
            vec[i] = n-count;
            vec[i+1] = n-count;
            count++;
        }
        return vec;
    }
    
    public static void main(String[] args){
    	//int[][] a ={{2,3},{4,5}};
    	//tools.print2dArray(a);
    	tools.print2dArray(generateMatrix(0));
    }
}
