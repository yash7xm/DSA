class Solution {
    public static int solve(int n, int k){
        if(n==1) return 0; // as no elemnet is  left 
        int x=solve(n-1,k); // give us the answer from n-1
        int y=(x+k)%n;
        return y;
    }
    public int findTheWinner(int n, int k) {
        return 1+solve(n,k); // do 1+ is we have to find ans between [1,n] else don't 
    }
}
