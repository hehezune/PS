package test1;

import java.util.*;
import java.io.*;

public class boj24542 {
	// 24542 튜터-튜티 관계의 
	static int[] size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[N + 1];
		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			edges[i] = new ArrayList<>();
		}
		size = new int[N + 1];
		for (int i = 1; i <= N; i++) size[i] = 1;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			unionParent(a, b, parent);
		}
		
		// 집합 원소 수의 곱 계
		long result = 1;
		for (int i = 1; i <= N; i++) {
			if (i != parent[i]) continue; // 루트가 아닌거는 패
			result = result * size[i] % 1000000007;
		}
		
		System.out.println(result);
	}
	
	static int findParent(int a, int[] parent) {
		if (parent[a] != a) {
			parent[a] = findParent(parent[a], parent);
		}
		return parent[a];
	}
	
	static void unionParent(int a, int b, int[] parent) {
		// union 시킬때 size도 반영하도록 포
		int parentA = findParent(a, parent);
		int parentB = findParent(b, parent);
		
		if (parentA == parentB) return;
		if (size[parentA] < size[parentB]) {
			int tmp = parentA;
			parentA = parentB;
			parentB = tmp;
		}
		parent[parentB] = parentA;
		size[parentA] += size[parentB];
		return;
	}
}
