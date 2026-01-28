// PAIR APPROACH(QUEUE)
class Solution {
    class pair{
        int n,i;
        pair(int n,int i){
            this.n=n;
            this.i=i;
        }
    }
    public int timeRequiredToBuy(int[] arr, int k) {
        int m=arr.length;
        if(m==1) return arr[0];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            q.add(new pair(arr[i],i));
        }
        int ans=0;
        while(!q.isEmpty()){
            pair p=q.poll();
            if(p.i==k){
                if(p.n==1) return ans+1;
                else q.add(new pair(p.n-1,p.i));
            }
            else{
                if(p.n>1){
                    q.add(new pair(p.n-1,p.i));
                }
            }
            ans++;
        }
        return -1;
    }
}

// SECOND APPROACH
class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int ans=0;
        while(!q.isEmpty()){
            int t=q.remove();
            arr[t]--;
            ans++;
            if(arr[t]!=0) q.add(t);
            if(arr[k]==0) return ans;
        }
        return ans;
    }
}


// OPTIMAL APPROACH
class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<k;i++){
            ans+=Math.min(arr[k],arr[i]);
        }
        ans+=arr[k];
        for(int i=k+1;i<n;i++){
            ans+=Math.min(arr[k]-1,arr[i]);
        }
        return ans;
    }
}
