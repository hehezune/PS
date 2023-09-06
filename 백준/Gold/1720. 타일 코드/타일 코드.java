import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 2];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 2] * 2 + dp[i - 1];
		}
		int answer = 0;
		if (N % 2 == 0) {
			answer = (dp[N] + dp[N / 2] + dp[N / 2 - 1] * 2) / 2;
		} else {
			answer = (dp[N] + dp[N / 2]) / 2;
		}
		System.out.println(answer);
	}
}