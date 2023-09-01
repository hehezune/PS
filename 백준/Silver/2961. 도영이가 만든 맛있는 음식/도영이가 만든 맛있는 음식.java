import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result = 2000000000;
    static int[] sour;
    static int[] bitter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        combinations(0, 0, 1, 0);

        System.out.println(result);
    }

    private static void combinations(int idx, int select, int sourSum, int bitterSum) {
        if (select > 0) {
            result = Math.min(result, Math.abs(sourSum - bitterSum));
        }
        if (idx == N) {
            return ;
        }

        for (int i = idx; i < N; i++) {
            combinations(i + 1, select, sourSum, bitterSum);
            combinations(i + 1, select + 1, sourSum * sour[i] ,bitterSum + bitter[i]);
        }
    }
}
