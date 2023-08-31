import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;
    static int[][] test;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        test = new int[N][M];
        
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (visited[y][x]) continue;
                if (isHaveTop(y, x, map[y][x])) {
                    result++;
                    // 한 번 싹 밀어버리는 과정이 필요함. 낮은 높이도 꼭대기 처리할 수 있음
                }
            }
        }

        System.out.println(result);
//        for (int y = 0; y < N; y++) {
//        	System.out.println(Arrays.toString(test[y]));
//        }
    }

    private static boolean isHaveTop(int startY, int startX, int height) {
    	
    	// top 가지고 있으면 속행
    	// top이 없으면 (아님이 판명되면) 즉시 false 리턴
    	visited[startY][startX] = true;
    	
    	for (int d = 0; d < 8; d++) {
    		int y = startY + dy[d];
    		int x = startX + dx[d];
    		
    		if (x < 0 || y < 0 || N <= y || M <= x) continue;
    		if (map[y][x] == height && !visited[y][x]) {
    			if (!isHaveTop(y, x, height)) {
    				return false;
    			}
    		}
    	}
    	
    	for (int d = 0; d < 8; d++) {
    		int y = startY + dy[d];
    		int x = startX + dx[d];
    		
    		if (x < 0 || y < 0 || N <= y || M <= x) continue;
    		if (height < map[y][x]) {
    			return false;
    		}
    	}
    	return true;
    }
}