class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer>res = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        int i = 0,j =0;
        while(j<arr.length){
            if(arr[j]<0){
            q.add(arr[j]);
            }
            if(j-i+1<k) j++;
            else if(j-i+1 == k){
                if(!q.isEmpty()){
                    res.add(q.peek());
                }else{
                    res.add(0);
                }
                
                // slid window
                if(!q.isEmpty() && arr[i] == q.peek()){
                    q.poll();
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
