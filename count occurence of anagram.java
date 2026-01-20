class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character,Integer>map = new HashMap<>();
        for(char c:pat.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int i =0,j=0;
        int k = pat.length();
        int count = map.size();
        int ans =0;
        while(j<txt.length()){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)count--;
            }
            if(j-i+1<k)j++;
            else if(j-i+1 == k){
                if(count == 0)ans++;
                
                // slide window
                
                char left = txt.charAt(i);
                if(map.containsKey(left)){
                    map.put(left, map.get(left)+1);
                    
                    if(map.get(left)==1)count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
