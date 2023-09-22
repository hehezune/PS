class Solution {
     int N, M;
     int[][] sKey, sLock, temp;
    
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        sKey = key;
        sLock = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
        temp = new int[M][M];
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                sLock[M - 1 + y][M - 1 + x] = lock[y][x];
            }
        }
        for (int n = 0; n < 4; n++) {
            
        for (int y = 0; y < N + M - 1; y++) {
            for (int x = 0; x < N + M - 1; x++) {
                coloring(y, x);
                if (checking()) {
                    return true;
                }
                clearing(y, x);
            }
        }
            turn90();
        }
        return false;
    }
    
    public void coloring(int Y, int X) {
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < M; x++) {
                temp[y][x] = sLock[Y + y][X + x];
                sLock[Y + y][X + x] += sKey[y][x];
            }
        }
    }
    
    public boolean checking() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (sLock[M - 1 + y][M - 1 + x] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void clearing(int Y, int X) {
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < M; x++) {
                sLock[y + Y][X + x] = temp[y][x];
            }
        }
    }
    
    public void turn90() {
        int[][] newArr = new int[M][M];
        
        for (int x = 0; x < M; x++){
            for (int y = 0; y < M; y++) {
                newArr[x][M - 1 - y] = sKey[y][x];
            }
        }
        
        sKey = newArr;
    }
    
}
