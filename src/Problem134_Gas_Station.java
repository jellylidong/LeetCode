
public class Problem134_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasL = gas.length;
        int costL= cost.length;
        if(gasL != costL)
            return -1;
        for(int i = 0; i < gasL; ){
            int remain = 0;
            for(int j = i; j < i+gasL; j++){
                int cur = j;
                if(j >= gasL)
                    cur = j - gasL;
                remain = remain + gas[cur] - cost[cur];
                if(remain < 0){
                    i = j;
                    break;
                }
                else if(j == i+gasL-1)
                    return i;
            }
            i++;
        }
        return -1;
    }
}
