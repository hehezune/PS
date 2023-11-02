# 덧칠하기
단순 계산, 그리드?
## 풀이 시간
32분
## 취약점
좀더 세밀하게 디테일하게 생각하지 못한 점?  
section[i]와 current가 같다면 해당 영역도 이미 칠해진 거니 continue 하면 되는데 처음에 < 로 조건을 걸어서 오답
## 코드
```java
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
```
