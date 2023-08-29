import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] countBall = new int[N + 1];
        int[] bottomballSize = new int[N + 1];
        bottomballSize[1] = 1;
        for (int i = 2; i < N; i++) {
            if (bottomballSize[i - 1] > N) break;
            bottomballSize[i] = bottomballSize[i - 1] + i;
        }
        int[] countOfBall = new int[N + 1];
        countOfBall[1] = 1;
        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }
        int countOfBallIdx = 2;
        for (; countOfBall[countOfBallIdx - 1] <= N; countOfBallIdx++) {
            countOfBall[countOfBallIdx] = countOfBall[countOfBallIdx - 1] + bottomballSize[countOfBallIdx];
        }

        for (int i = 1; i <= N; i++) {
            countBall[i] = i;
        }

        for (int typeIdx = 2; typeIdx < countOfBallIdx; typeIdx++) {
            int ballCount = countOfBall[typeIdx];
            for (int i = ballCount; i <= N; i++) {
                countBall[i] = Math.min(countBall[i], countBall[i - ballCount] + 1);
            }
        }

        System.out.println(countBall[N]);
    }
}