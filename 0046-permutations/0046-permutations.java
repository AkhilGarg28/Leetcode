class Solution {
    public static void solve(int[] arr, int idx,List<Integer> curr, boolean[] use,List<List<Integer>> res){
        if(idx == arr.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!use[i]){
                curr.add(arr[i]);
                use[i] = true;
                solve(arr,idx+1,curr,use,res);
                curr.remove(curr.size()-1);
                use[i] = false;
            }
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        int n = nums.length;
        solve(nums,0,new ArrayList<>(),new boolean[n],res);
        return res;
    }
}