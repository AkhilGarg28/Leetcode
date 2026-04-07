import java.util.*;

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();

        for (int num : nums) {
            long curr = num;

           
            while (!st.isEmpty() && st.peek() == curr) {
                curr += st.pop();
            }

            st.push(curr);
        }

        return new ArrayList<>(st);
    }
}