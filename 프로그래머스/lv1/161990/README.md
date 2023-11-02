# 바탕화면 정리
* 수학문제?, 2차원 배열 문제
## 취약점
* 문제를 꼼꼼히 읽지 않아 y, x의 일반적인 정의(y 세로 x 가로)가 뒤집어 있는것을 파악하지 못함
## 소요 시간
* 20분
---
```java
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
```
