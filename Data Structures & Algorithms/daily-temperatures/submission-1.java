class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int prev=st.pop();
                res[prev]=i-prev;
            }
            st.push(i);
        }

        return res;
    }
}
