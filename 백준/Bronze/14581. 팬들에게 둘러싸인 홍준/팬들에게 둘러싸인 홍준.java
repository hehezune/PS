import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		String fan = ":fan:";
		
		sb.append(fan + fan + fan + "\n").append(fan + ":" + input + ":" + fan + "\n").append(fan + fan + fan);
		System.out.println(sb);
	}
}
