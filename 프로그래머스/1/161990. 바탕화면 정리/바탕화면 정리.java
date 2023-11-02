class Solution {
    int lx = 50, ly = 50, rx = 0, ry = 0;
    public int[] solution(String[] wallpaper) {
        for (int y = 0; y < wallpaper.length; y++) {
            for (int x = 0; x < wallpaper[y].length(); x++) {
                if (wallpaper[y].charAt(x) == '#') {
                    lx = Math.min(lx, x);
                    ly = Math.min(ly, y);
                    rx = Math.max(rx, x);
                    ry = Math.max(ry, y);
                }
            }
        }
        int[] answer = {ly, lx, ry + 1, rx + 1};
        return answer;
    }
}