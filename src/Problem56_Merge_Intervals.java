import java.util.*;
public class Problem56_Merge_Intervals {
	//this method shuold work fine, but exceed time limit
	/*public List<Interval> merge(List<Interval> intervals) {
        for(int i = 0 ; i < intervals.size(); i++){
            for(int j = i+1; j < intervals.size(); j++)
            {
                if(intervals.get(j).start > intervals.get(j-1).start){
                    swap(intervals.get(j), intervals.get(j-1));
                }
            }
        }
        for(int i = 1 ; i < intervals.size() && i >= 0; ){
            
            if(overlap(intervals.get(i), intervals.get(i-1))){
                Interval tmp = merge(intervals.get(i), intervals.get(i-1));
                intervals.set(i, tmp);
                intervals.remove(i-1);
                i--;
                if(intervals.size() <= 1 || i == 0)
                    break;
            }
            else
                i++;
        }
        return intervals;
    }
    
    public Interval merge(Interval i1, Interval i2){
        int min = Math.min(i1.start, i2.start);
        int max = Math.max(i1.end,   i2.end);
        return new Interval(min, max);
    }
    
    public boolean overlap(Interval i1, Interval i2){
        if( (i1.start >= i2.start && i1.start <= i2.end ) ||
            (i2.start >= i1.start && i2.start <= i1.end ))
            return true;
        return false;
            
    }
    
    public void swap(Interval i1, Interval i2){
        int start = i1.start;
        int end = i1.end;
        i1.start = i2.start;
        i1.end = i2.end;
        i2.start = start;
        i2.end =end;
    }*/
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
        @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        
        List<Interval> res = new ArrayList<>();
        Interval tmp = new Interval(0, 0);
        boolean merged = false;
        for(int i = 1 ; i <= intervals.size(); i++ ){
            if(!merged)
                tmp = intervals.get(i-1);
            if(i < intervals.size() && overlap(intervals.get(i), tmp) ){
                tmp = merge(intervals.get(i), tmp);
                merged = true;
                
            }
            else{
                merged = false;
                res.add(tmp);
            }
                
        }
        
        return res;
    }
    
    public Interval merge(Interval i1, Interval i2){
        int min = Math.min(i1.start, i2.start);
        int max = Math.max(i1.end,   i2.end);
        return new Interval(min, max);
    }
    
    public boolean overlap(Interval i1, Interval i2){
        if( (i1.start >= i2.start && i1.start <= i2.end ) ||
            (i2.start >= i1.start && i2.start <= i1.end ))
            return true;
        return false;
            
    }
    
    public void swap(Interval i1, Interval i2){
        int start = i1.start;
        int end = i1.end;
        i1.start = i2.start;
        i1.end = i2.end;
        i2.start = start;
        i2.end =end;
    }
}
