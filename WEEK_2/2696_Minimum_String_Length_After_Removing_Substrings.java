class Solution {
    public int minLength(String s) {
        int n=s.length();
        if(n<=1) return 1;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.size()<1) st.push(s.charAt(i));
            else if(((st.peek()+""+s.charAt(i)).equals("AB")) || (st.peek()+""+s.charAt(i)).equals("CD")){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
}
