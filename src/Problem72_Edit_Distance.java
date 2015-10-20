
public class Problem72_Edit_Distance {
	public static int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		
		if(l1 == 0)
			return l2;
		if(l2 == 0)
			return l1;
		int[][] dis = new int[l1+1][l2+1];
		for(int i = 0; i < l1+1; i++)
			dis[i][0] = i;
		for(int i = 0; i < l2+1; i++)
			dis[0][i] = i;
		
		for(int i =1; i < l1+1; i++){
			for(int j = 1; j < l2+1; j++){
				int insert = dis[i][j-1] + 1;
				int delete = dis[i-1][j] + 1;
				int replace= dis[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)?0:1);
				dis[i][j] = min3(insert, delete, replace);
			}
		}
	    return dis[l1][l2];
	}
	
	public static int min3(int n1, int n2, int n3){
		int tmp = Math.min(n1, n2);
		return Math.min(tmp, n3);
	}
	
	public static void main(String[] args){
		String s1 = "b";
		String s2 = "a";
		System.out.println(minDistance(s1,s2));
	}
}
