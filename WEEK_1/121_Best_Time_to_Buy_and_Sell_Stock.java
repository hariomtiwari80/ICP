// BRUTE FORCE
class Solution {
    public int maxProfit(int[] arr) {
        int p=0,n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                p=Math.max(p,arr[j]-arr[i]);
            }
        }
        return p;
    }
}

// OPTIMAL APPROACH
class Solution {
    public int maxProfit(int[] prices) {
        int b=Integer.MAX_VALUE;
        int s=0;
        for(int i=0;i<prices.length;i++){
            b=Math.min(b,prices[i]);
            s=Math.max(s,prices[i]-b);
        }
        return s;
    }
}
