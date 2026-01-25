class Solution {
    
    int longestUniqueSubstring(String s) {
        // code here
        HashMap<Character,Integer>mp = new HashMap<>();
        int i=0,j=0;
        int max = -1;
        
        while(j<s.length()){
            char ch = s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            
            if(mp.size() == j-i+1){
                max = Math.max(max,j-i+1);
                j++;
            }
            else if(mp.size()<j-i+1){
                while(mp.size()<j-i+1){
                    char leftch = s.charAt(i);
                    mp.put(leftch, mp.get(leftch)-1);
                    
                    if(mp.get(leftch) == 0){
                        mp.remove (leftch);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
