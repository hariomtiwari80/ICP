// BRUTE FORCE
class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int ans=0;
        for(int i=2;i<n;i++){
            if(prime(i)) ans++;
        }
        return ans;
    }
    public boolean prime(int n){
        if(n==2) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

// OPTIMAL APPROACH
class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] b=new boolean[n];
        for(int i=2;i*i<=n;i++){
            if(b[i]==false){
                for(int j=i*i;j<n;j+=i){
                    b[j]=true;
                }
            }
        }
        int ans=0;
        for(int i=2;i<n;i++){
            if(!b[i]) ans++;
        }
        return ans;
    }
}
