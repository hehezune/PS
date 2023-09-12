import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] names;
    static long[][] tracks;
    static int result = 987654321;
    static long[] factor = new long[2];
    static long[] goalNumber = new long[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        names = new String[N];
        tracks = new long[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            String track = st.nextToken();
            int length = track.length();
            int idx = 0;
            while (idx < length){
                int trackIdx = 0;
                int correction = 0;
                if (idx > 25) {
                    trackIdx = 1;
                    correction = 25;
                }
                if (track.charAt(idx) == 'Y') {
                    tracks[i][trackIdx] |= 1 << (idx - correction);
                    goalNumber[trackIdx] |= 1 << (idx - correction);
                }
                idx++;
            }
//            System.out.println(tracks[i][0] + " " + tracks[i][1]);
        }
        if (goalNumber[0] + goalNumber[1] == 0L) {
            System.out.println(-1);
            System.exit(0);
        }
        permutation(0, 0);
        System.out.println(result);
    }

    private static void permutation(int idx, int select) {
        if (goalNumber[0] == factor[0] && goalNumber[1] == factor[1]) {
            result = Math.min(result, select);
//            System.out.println(idx + " " + select);
            return ;
        }
        if (idx == N) {
            return ;
        }
        long[] origin = new long[2];
        permutation(idx + 1, select);
        origin[0] = factor[0];
        origin[1] = factor[1];
        factor[0] |= tracks[idx][0];
        factor[1] |= tracks[idx][1];
        permutation(idx + 1, select + 1);
        factor[0] = origin[0];
        factor[1] = origin[1];
    }
}
