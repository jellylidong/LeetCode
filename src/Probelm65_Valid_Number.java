
public class Probelm65_Valid_Number {
	//private static boolean  E = false;
	//private static boolean	D = false;
	//private static boolean trimed = false;
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.isEmpty())
            return false;
		int countD = 0;
        int countE = 0;
		boolean hasNbeforeE = false;
        boolean hasNbehindE = false;
        boolean hasS = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                if(countE == 0)
                    hasNbeforeE = true;
                else
                    hasNbehindE = true;
            }
            else if(c == '.'){
                
                    if(countE == 1)
                        return false;
                    countD++;
                    if(countD >= 2)
                        return false;
                
            }
            else if(c == 'e'){
                if(!hasNbeforeE)
                    return false;
                countE++;
                if(countE >= 2)
                    return false;
                return isNumber(s.substring(i+1), true);
            }
            else if(c == '+' || c == '-'){
                if(hasNbeforeE ||hasNbehindE || countE != 0 || countD != 0)
                    return false;
                if(hasS)
                    return false;
                hasS = true;
            }
            else return false;
        }
        if(countD != 0 && !(hasNbeforeE || hasNbehindE))
            return false;
        if(countE != 0 && !hasNbehindE)
            return false;
        return true;
    }
	
	public static boolean isNumber(String s, boolean aE){
		if(s.isEmpty())
			return false;
		boolean N = false;
		boolean S = false;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!(c >= '0' && c <= '9') && !(c == '+' || c == '-'))
				return false;
			if(c >= '0' && c <= '9')
				N = true;
			else{
				if(N || S)
					return false;
				S = true;
			}
		}
		if(S && !N)
		    return false;
		return true;
	}
}