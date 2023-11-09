import java.util.*;

class Solution {
    int length;
    public int solution(String name) {
        length = name.length();
        boolean[] check = new boolean[length];
        int answer = 0;
        int tCount = length;
        for (int i = 0; i < length; i++) {
            int temp = diffChar(name.charAt(i));
            answer += temp;
            if (temp == 0) {
                check[i] = true;
                tCount--;
            } 
        }
        
        answer += getSmallLength(check, tCount);
        return answer;
    }
    
    public int diffChar(char target) {
        int a = Math.abs(target - 'A');
        int b = Math.abs('Z' - target + 1);
        return Math.min(a, b);
    }
    
    public int getSmallLength(boolean[] check, int tCount) {
        // tCount가 방문해야 하는 친구의 갯수
        // System.out.println(tCount);
        if (!check[0]) {
            tCount--;
        }
        
        int count = length - 1;
        
        for (int i = 0; i < check.length; i++) {
            int idx = i + 1;
            while (idx < length && check[idx]) idx++;
            count = Math.min(count, i * 2 + length - idx);
            count = Math.min(count, (length - idx) * 2 + i);
        }
        
        return count;
    }
}