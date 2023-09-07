import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            findNetwork(i, n, computers);
            answer++;
        }
        return answer;
    }
    
    public void findNetwork(int target, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int j = 0; j < n; j++) {
            if (visited[j] || computers[target][j] == 0) continue;
            visited[j] = true;
            queue.add(j);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int i = 0; i < n; i++) {
                if (visited[i] || computers[current][i] == 0) continue;
                visited[i] = true;
                queue.add(i);
            }
        }
    }
}
