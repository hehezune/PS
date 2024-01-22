import java.util.*;

class Solution {
    int[][] match;
    public int solution(int n, int[][] results) {
        match = new int[n + 1][n + 1];
        
        for (int[] result : results) {
            int A = result[0], B = result[1];
            match[A][B] = 1;
            match[B][A] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (match[i][k] == 1 && match[k][j] == 1) {
                        match[i][j] = 1;
                        match[j][i] = -1;
                    }
                    if (match[i][k] == -1 && match[k][j] == -1) {
                        match[i][j] = -1;
                        match[j][i] = 1;
                    }
                }
            }
        }
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (match[i][j] == 0) continue;
                count++;
            }
            if (count == n - 1) {
                answer++;
            }
        }
        return answer;
    }   
}