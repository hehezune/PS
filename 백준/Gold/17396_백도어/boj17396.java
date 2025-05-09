package test1;

import java.util.*;
import java.io.*;

public class boj17396 {
	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<int []>[] edges = new ArrayList[N];
		long[] shortLength = new long[N];

		boolean[] isWatched = new boolean[N];
		
		st = new StringTokenizer(bf.readLine());
		
		// 입력 
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
			isWatched[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
			shortLength[i] = Long.MAX_VALUE;
		}
	
		isWatched[N - 1] = false;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (isWatched[a] || isWatched[b]) continue;
			int length = Integer.parseInt(st.nextToken());
			edges[a].add(new int[] {b, length});
			edges[b].add(new int[] {a, length});
		}
		
		// pq 기반 다익스트라 
		PriorityQueue<long []> pq = new PriorityQueue<>((a, b) -> (Long.compare(a[1], b[1])));
		pq.add(new long[] {0, 0});
		shortLength[0] = 0;
		
		while(!pq.isEmpty()) {
			long[] current = pq.poll();

			if (current[1] > shortLength[(int) current[0]]) continue;
			
			
			for (int[] nextNode : edges[(int) current[0]]) {
				int nextIdx = nextNode[0];
				if (shortLength[nextIdx] > current[1] + nextNode[1]) {
					shortLength[nextIdx] = current[1] + nextNode[1];
					pq.add(new long[] {nextIdx, shortLength[nextIdx]});
				}
			}
		}
		System.out.println(shortLength[N - 1] == Long.MAX_VALUE ? -1 : shortLength[N - 1]);
	}
}
