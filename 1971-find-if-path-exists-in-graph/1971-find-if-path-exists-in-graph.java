class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == destination) {
                return true;
            }
            for (int nbr : g.get(current)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.offer(nbr);
                }
            }
        }
        return false;
    }
}