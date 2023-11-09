# 조이스틱
- 수학적 사고?

## 취약점
- 나의 오논리를 맞왜틀 하며 고수한 것
- 실제 코테로 이런 저수준 테케만 제공한다면 십중팔구 틀렸을 것
- 당연히 최소값은 왼쪽 or 오른쪽 일방통행으로만 이루어진다고 생각했으나, 길이가 길어질 경우 이야기가 달라진다.

## 코드
```java
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
        
        int leftCount = tCount, rightCount = tCount;
        int leftLength = length - 1, rightLength = length - 1;
        for (int i = 1; i < check.length; i++) {
            // System.out.println(leftCount + " " + leftLength + " " + rightCount + " " + rightLength);
            if (!check[i]) {
                rightCount--;
                if (rightCount == 0) {
                    rightLength = i;
                }
            }
            if (!check[length - i]) {
                leftCount--;
                if (leftCount == 0) {
                    leftLength = i;
                }
            }
        }
        // System.out.println(leftLength + " " + rightLength);
        return Math.min(leftLength, rightLength);
    }
}
```
