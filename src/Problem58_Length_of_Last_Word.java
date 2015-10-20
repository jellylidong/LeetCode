
public class Problem58_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
        int preCounter = 0;
        int curCounter = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                if(curCounter != 0)
                    preCounter = curCounter;
                curCounter = 0;
            }
            else
                curCounter++;
            i++;
        }
        if(curCounter != 0)
            return curCounter;
        return preCounter;
    }
}
