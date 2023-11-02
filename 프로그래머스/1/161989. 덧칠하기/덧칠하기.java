class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int current = section[0] + m - 1;
        
        for (int i = 1; i < section.length; i++) {
            if (section[i] <= current) continue;
            current = section[i] + m - 1;
            answer++;
        }
        // 1 2 3 4 5 6 7 8
        //     x       x   
        return answer;
    }
}