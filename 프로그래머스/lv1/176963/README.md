# 추억 점수
- 해시맵

## 취약점
- 문제를 꼼꼼히 읽지 않음 : phot에서 명시되는 이름 중, map에 존재하지 않는 이름이 들어갈 수도 있음을 인지 못함

## 코드
```java
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> score = new HashMap<>();
        int size = photo.length;
        
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            int value = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (!score.containsKey(photo[i][j])) continue;
                value += score.get(photo[i][j]);
            }
            answer[i] = value;
        }
        return answer;
    }
}
```
