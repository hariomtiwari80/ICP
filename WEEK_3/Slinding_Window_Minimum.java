import java.util.*;

public class MinSub {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int[] ans=new int[n-k+1];
        int l=0;
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]>arr[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                ans[l++]=dq.peekFirst();
            }
        }
        for(int x:ans){
            System.out.print(x+1+" ");
        }
    }
}
