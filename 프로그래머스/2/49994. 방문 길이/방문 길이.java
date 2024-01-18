import java.util.*;

class Solution {
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
    boolean[][][] visited = new boolean[2][11][11];
    int answer = 0;
    Map<Character, Integer> command = new HashMap<>();
    
    public int solution(String dirs) {
        int y = 5, x = 5;
        int dirIdx = -1;
        int tempX = x, tempY = y;
        command.put('U', 0);
        command.put('D', 1);
        command.put('R', 2);
        command.put('L', 3);
        
        for (int i = 0; i < dirs.length(); i++) {
            int direction = command.get(dirs.charAt(i));
            tempY = y + dy[direction];
            tempX = x + dx[direction];
            dirIdx = direction < 2 ? 0 : 1;

            if (tempY < 0 || tempX < 0 || tempY > 10 || tempX > 10) {
                tempY = y;
                tempX = x;
                continue;
            }
            y = tempY;
            x = tempX;
            
            if (direction == 0) {
                tempY--;
            } else if (direction == 2) {
                tempX--;
            }
            
            if (!visited[dirIdx][tempY][tempX]) {
                    visited[dirIdx][tempY][tempX] = true;                      
                answer++;
            }
        }    
        return answer;
    }
}