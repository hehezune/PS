package test1;

import java.io.*;
import java.util.*;

public class boj32347 {
	// 시간을 돌리고 싶어
	public static void main (String[] args) throws IOException {
		// N일차, K 사용횟수 <= 2십만
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] onOff = new boolean[N];
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) {
			onOff[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		}
		
		int start = 1;
		int end = N - 1;
		int mid = (start + end) / 2;
		int count, result = 0;
	
		while(start <= end) {
			mid = (start + end) / 2;			
			count = getCount(mid, onOff, N, K);
			// 무한반복할 경우나 K회를 넘길 경우 -1 리
			if (count == -1) {
				start = mid + 1;
			} else {
				result = mid;
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}

	static int getCount(int t, boolean[] onOff, int N, int K) {
		boolean[] visited = new boolean[N];
		int count = 0;
		int cursor = N - 1;
		
		while (0 < cursor) {
			if (visited[cursor]) return -1;
			visited[cursor] = true;
			if (onOff[cursor]) {
				if (count == K) return -1;
				count++;
				cursor -= t;
				continue;
			}
			cursor++;
		}
		return count;
	}
}

