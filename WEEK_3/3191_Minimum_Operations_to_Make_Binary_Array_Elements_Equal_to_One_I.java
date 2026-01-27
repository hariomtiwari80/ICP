class Solution {
    public int minOperations(int[] arr) {
        int i=0;
        int n=arr.length;
        int ans=0;
        while(i<=n-3){
            if(arr[i]==1){
                i++;
            }
            else{
                ans++;
                arr[i]=1;
                if(arr[i+1]==0){
                    arr[i+1]=1;
                }
                else if(arr[i+1]==1){
                    arr[i+1]=0;
                }
                if(arr[i+2]==0){
                    arr[i+2]=1;
                }
                else if(arr[i+2]==1){
                    arr[i+2]=0;
                }
            }
        }
        while(i<n){
            if(arr[i]==0) return -1;
            i++;
        }
        return ans;
    }
}
