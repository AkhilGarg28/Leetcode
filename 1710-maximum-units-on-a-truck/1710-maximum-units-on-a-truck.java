import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int total = 0;

        for (int[] box : boxTypes) {
            int take = Math.min(truckSize, box[0]);
            total += take * box[1];
            truckSize -= take;

            if (truckSize == 0) break;
        }

        return total;
    }
}