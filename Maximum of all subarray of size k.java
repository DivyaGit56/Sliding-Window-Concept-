class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        Deque<Integer>dq = new LinkedList<>();
        int i =0,j =0;
        while(j<arr.length){
            while(!dq.isEmpty() && dq.peekLast()<arr[j]){
                dq.pollLast();
            }
            dq.addLast(arr[j]);
            
            if(j-i+1<k)j++;
            else if(j-i+1 == k){
                ans.add(dq.peekFirst());
            
            // to remove i element
            if(arr[i] == dq.peekFirst()){
                dq.pollFirst();
            }
            i++;
            j++;
            }
        }
        return ans;
    }
}
