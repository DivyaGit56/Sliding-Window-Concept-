class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer>map = new HashMap<>();
        int i=0,j=0;
        int max = -1;
        
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.size()<k)j++;
            
            else if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++;
            }
            
            else if(map.size()>k){
                
            while(map.size()>k){
                char leftch = s.charAt(i);
                map.put(leftch, map.get(leftch)-1);
                    
                if(map.get(leftch) == 0){
                    map.remove(leftch);
                }
                i++;
            }
            j++;
                
            }
        }
        return max;
    }
}
