import java.util.*;

public class Problem127_Word_Ladder {
	public int ladderLength(String s1, String s2, Set<String> dict) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s1);
        q.offer(null);
        visited.add(s1);
        
        int level = 1;
        
        while(!q.isEmpty()){
            String s = q.poll();
            if(s != null){
               StringBuilder sb = new StringBuilder(s);
               for(int i = 0; i < s.length(); i++){
                    char tmp = s.charAt(i); // store the char that will be changed
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(i, c);
                        String newStr = sb.toString();
                        if(newStr.equals(s2))    return level+1;
                        if(dict.contains(newStr) && !visited.contains(newStr)){
                            q.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                    sb.setCharAt(i, tmp); // after changed char has been put into the queue, change back
               }
            }
            else{
                level++;
                if(!q.isEmpty())
                    q.offer(null); //this is used to count steps, when poll an null out, one more step close.
                                   //go through the exmaple in the description and look at the queue, you'll see.
            }
        }
        return 0;
    }
}
/*how to ensure shortest path?
Hi Owls, when we perform the BFS, we will return as soon as we find a word in the dictionary that is 1 edit distance to the target word.

It's like we try to find a person in a building, we scan all the rooms from level 1, level 2 till level 10, and we won't go to level 2 if we haven't searched all the rooms on level 1, so we make sure there's no such case where we have to go up to level 10 then come down to level 5 and find the person.

Hope that makes sense.
 * */
