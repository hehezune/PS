import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int size = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < size; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    k--;
                    n += pq.poll();
                } else {
                    return i;
                }
            }
        }
        return size;
    }
}