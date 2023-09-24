import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = Integer.parseInt(br.readLine());
		for (int i = 1; i <= a; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			System.out.println("Case #" + i + ": " + b + " + " + c + " = " + (b + c) );
		}
	}
}
