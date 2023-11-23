# 1351 무한수열

## 알고리즘
dp

## 취약점
공간복잡도에 대한 이해?
int 갯수를 넘어가는 공간복잡도는 어떻게 극복할 것인가?

## 접근 전략
int 범위 넘어가는 것은 map으로 처리하자!
map은 어떤 원리에 의해 넓은 공간복잡도를 처리할 수 있는지 공부가 필요

### code
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static double P, Q;
    static Map<Long, Long> map = new HashMap<>();

    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map.put(0L, 1L);

        System.out.println(getResult(N));
    }

    public static long getResult(long i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }

        long value = getResult((long)(Math.floor(i / P))) + getResult((long)(Math.floor(i / Q)));
        map.put(i, value);
        return value;
    }
}

```
