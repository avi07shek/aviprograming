import java.util.*;

class que4a {

    public int minNumberOfSteps(int N, int[][] prerequisites) {

        

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        

        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            graph.get(x).add(y);
        }

      

        int[] inDegree = new int[N + 1];
        for (int[] prerequisite : prerequisites) {
            int y = prerequisite[1];
            inDegree[y]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {

            if (inDegree[i] == 0) {

                queue.add(i);

            }

        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                N--;
                for (int neighbor : graph.get(curr)) {
                    if (--inDegree[neighbor] == 0) {
                        queue.add(neighbor);

                    }
                }
            }
            steps++;
        }
        return N == 0 ? steps : -1;
    }

    public static void main(String[] args) {

        int N = 3;
        int[][] r = {{1, 3}, {2, 3}};
        que4a solution = new que4a();
        System.out.println(solution.minNumberOfSteps(N, r));

    }

}

