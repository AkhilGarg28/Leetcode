class Solution {
    public int missingNumber(int[] nums) {
        int a =0 ;
        for ( int x : nums){
            a^=x;
        }
        for(int i =0;i<=nums.length;i++){
        a^=i;
    }
    return a;
    }
}