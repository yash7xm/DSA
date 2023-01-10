class Solution {
    public static void dfs(int i, int n, List<Integer> list){
        if(i>n) return;
        list.add(i); // adding  first as like preorder 
        for(int j=0; j<10; j++){
            dfs(i*10+j,n,list);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1; i<=9; i++){
            dfs(i,n,list);
        }
        return list;
    }
}
