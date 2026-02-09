class Solution {
    class pair{
        int i,j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

    public int totalSteps(int[] arr) {
        Stack<pair> st=new Stack<>();
        int ans=0;
        for (int x:arr) {
            int s=0;
            while(!st.isEmpty() && st.peek().i <= x) {
                s=Math.max(s,st.peek().j);
                st.pop();
            }
            if (!st.isEmpty()) s++;
            else s=0;
            ans=Math.max(ans,s);
            st.push(new pair(x,s));
        }
        return ans;
    }
}
