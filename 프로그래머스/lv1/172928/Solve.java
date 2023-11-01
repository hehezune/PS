import java.util.*;

class Solution {
    Map<Character, Integer> way = new HashMap<>();
    int[] dy = {0, 1, 0, -1};
    int[] dx = {1, 0, -1, 0};
    int[] start = new int[2];
    int[] goal = new int[2];
    int maxY, maxX;
    String[] sPark;
    
    public int[] solution(String[] park, String[] routes) {
        setStartPoint(park);
        maxY = park.length;
        maxX = park[0].length();
        sPark = park;
        int y = start[0];
        int x = start[1];
        way.put('E', 0);
        way.put('S', 1);
        way.put('W', 2);
        way.put('N', 3);
        
        for (int i = 0; i < routes.length; i++) {
            char d = routes[i].charAt(0);
            int length = routes[i].charAt(2) - '0';
            
            if (!isCanPass(y, x, way.get(d), length)) continue;
            y += dy[way.get(d)] * length;
            x += dx[way.get(d)] * length;
        }
        
        int[] answer = {y, x};
        return answer;
    }
    
    public boolean isCanPass(int y, int x, int d, int length) {
        for (int i = 1; i <= length; i++) {
            int nextY = y + dy[d] * i;
            int nextX = x + dx[d] * i;
            
            if (nextY < 0 || nextX < 0 || maxY <= nextY || maxX <= nextX) return false;
            if (isInterupt(nextY, nextX)) return false;
        }
        
        return true;
    }
    
    public boolean isInterupt(int y, int x) {
        return sPark[y].charAt(x) == 'X';
    }
    
    public void setStartPoint(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                    return ;
                } 
            }
        }
    }
}
