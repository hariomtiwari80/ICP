class Solution {
    public String makeGood(String s) {
        int n=s.length();
        if(n<2) return s;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            int c1=(int)(c);
            int c2=(int)(st.peek());
            if(c1>=65 && c1<=90 && c2>=97 && c2<=122){
                if(c1+32==c2) st.pop();
                else st.push(c);
            }
            else if(c1>=97 && c1<=122 && c2>=65 && c2<=90){
                if(c1==c2+32) st.pop();
                else st.push(c);
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
