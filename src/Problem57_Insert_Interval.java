import java.util.*;
public class Problem57_Insert_Interval {
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        
        boolean put = false;
        //boolean needCheck = true;
        if(newInterval.end < intervals.get(0).start){
            res.add(newInterval);
            put = true;
            //needCheck = false;
        }
        for(int i = 0; i < intervals.size();){
            
            if(put || !overlap(newInterval, intervals.get(i))){
                if(newInterval.end < intervals.get(i).start && !put){
                    res.add(newInterval);
                    put = true;
                }
                res.add(intervals.get(i));
                i++;
            }
            
            else{
                while(i < intervals.size() && !put && overlap(newInterval, intervals.get(i))){
                    Interval tmp = intervals.get(i);
                    newInterval = merge(newInterval, tmp);
                    i++;
                }
                res.add(newInterval);
                put = true;
            }
        }
        if(!put)
            res.add(newInterval);
        
        //collection.sort()
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
}
