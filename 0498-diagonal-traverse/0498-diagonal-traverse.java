class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                currentLevel.add(mat[r][c]);
                if (i == 0 && c + 1 < n) {
                    queue.offer(new int[]{r, c + 1});
                }
                if (r + 1 < m) {
                    queue.offer(new int[]{r + 1, c});
                }
            }
            if (level % 2 == 0) {
                for (int i = currentLevel.size() - 1; i >= 0; i--) {
                    result[index++] = currentLevel.get(i);
                }
            } else {
                for (int i = 0; i < currentLevel.size(); i++) {
                    result[index++] = currentLevel.get(i);
                }
            }
            level++;
        }
        return result;
    }
}
