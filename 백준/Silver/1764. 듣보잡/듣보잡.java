import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		Set<String> newSet = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (set.contains(input)) {
				newSet.add(input);
			}
		}
		
		sb.append(newSet.size() + "\n");
		for (String target: newSet) {
			sb.append(target + "\n");
		}
		
		System.out.println(sb);
	}
}
