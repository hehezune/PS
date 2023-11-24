# BOJ_1446_지름길

## 알고리즘 분류
dp, 다익?

## 소요시간
풀이 참고 + 30min, 집중 제대로 안함

## 논리 전개
- dp를 한다면 memoization하는 기준이 무엇인가?
  - from인가, to인가? 어떤 것이 더 유리한가?
- to로 결정했다면, input들을 어떤 자료구조로 다룰 것인가?
  - array로 만든 다음에 정렬할 것인가?
  - list를 담는 map을 만들 것인가?
- Top-Down으로 진행할 것인가, Bottom-Up으로 진행할 것인가?
- 어떤게 개발에 유리한가? 익숙한가?

## 취약점
- 그냥 접근 자체를 하지 못했다
- dp 문제를 풀때 논리 전개하는 방식을 완전히 잊은 것 같다.

Top-Dwon 방식
```java
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PS1446 {
    static int N, D;
    static Map<Integer, List<int[]>> shortCut = new HashMap<>();

    static int FROM = 0, DIS = 1;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dp = new int[D + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (!shortCut.containsKey(to)) {
                shortCut.put(to, new ArrayList<>());
            }

            shortCut.get(to).add(new int[]{from, distance});
        }

        System.out.println(getResult(D));
//        System.out.println(Arrays.toString(dp));
    }

    public static int getResult(int idx) {
        if (idx == 0) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        dp[idx] = getResult(idx - 1) + 1;

        if (!shortCut.containsKey(idx)) return dp[idx];

        List<int[]> targetList = shortCut.get(idx);
        for (int[] target : targetList) {
//            System.out.println(idx + " " + target[FROM] + " " + target[DIS] + "\n");
            dp[idx] = Math.min(dp[idx], dp[target[FROM]] + target[DIS]);
        }
        return dp[idx];
    }
}

```
