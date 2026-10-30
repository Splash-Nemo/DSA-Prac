package graphs;

class Solution {
    public int[] findOrder(int n, int[][] pre) {
        int m = pre.length;

        List<List<Integer>> list = new ArrayList<>();

        int[] deg = new int[n];

        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            list.get(pre[i][1]).add(pre[i][0]);
            deg[pre[i][0]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();

        int[] ansList = new int[n];
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (deg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            ansList[index++] = curr;
            for (int k : list.get(curr)) {
                deg[k] -= 1;

                if (deg[k] == 0) {
                    q.add(k);
                }
            }
        }

        if (index != n)
            return new int[0];

        return ansList;

    }

    public void BFS(int[] deg, List<List<Integer>> list, int[] ansList, int index, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int curr = q.poll();

            ansList[index++] = curr;
            for (int k : list.get(curr)) {
                deg[k] -= 1;

                if (deg[k] == 0) {
                    q.add(k);
                }
            }
        }
    }
}
