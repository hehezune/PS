# 1106. 호텔

### 사용 아이디어
dp

### 소요 시간
약 1시간?

### 취약점
- 또 문제를 제대로 읽지 않음 : "적어도 C명 " 조건
- 뭔가 알고리즘적 사고를 하지 못함, 집중도 잘 안되는듯? 알을 다시 한 번 깨야 함
- 초기값 세팅할 때 채울 수 없는 경우는 놔둬야 함. 예를 들면 CUSTOMER 최소값이 2일 때, 홀수 부분들은 채우면 안된다는 이야기
  - 어차피 최소 C라는 조건으로 인해 N개를 딱 맞춰서 만들지 못하는 경우에라도 N + 1, N + 2 등등 추가 체크가 가능함

``` java
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class PS1106 {
    static int COST = 0, CUSTOMER = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] market = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            market[i][COST] = Integer.parseInt(st.nextToken());
            market[i][CUSTOMER] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(market, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[CUSTOMER], o2[CUSTOMER]);
            }
        });

        // 냅색 시작
        // CUSTOMER - C % 최대값
        // 추가 값
//        int fix = market[N - 1][CUSTOMER] - C % market[N - 1][CUSTOMER];
        int fix = 100;
        int max = C + fix;
        int[][] napsack = new int[N][max + 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(napsack[i], 99999);
            napsack[i][0] = 0;
        }
        // 초기값 설정
        for (int i = 1; i * market[0][CUSTOMER] <= max; i++) {
            napsack[0][i * market[0][CUSTOMER]] = i * market[0][COST];
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(market[i]));
//            System.out.println(Arrays.toString(napsack[i]));
//            ;
//        }
        for (int n = 1; n < N; n++) {
            for (int i = 1; i < market[n][CUSTOMER]; i++) {
                napsack[n][i] = napsack[n - 1][i];
            }
            for (int i = market[n][CUSTOMER]; i <= max; i++) {
//                if (napsack[n][i - market[n][CUSTOMER]] == 99999) napsack[n][i] = napsack[n - 1][i];
                napsack[n][i] = Math.min(napsack[n - 1][i], napsack[n][i - market[n][CUSTOMER]] + market[n][COST]);
            }
        }

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(napsack[i]));
//            ;
//        }

        int min = 987654321;
        for (int i = C; i <= max; i++
        ) {
            min = Math.min(min, napsack[N - 1][i]);
        }
        System.out.println(min);

    }
}

```
