# 경주로 건설_67259
- (0,0)에서 (N-1, N-1)까지, 벽을 피해 최소 코스트로 이동경로를 만드는 문제
- 방향을 바꿀 경우 (코너) 추가 비용 생김
- 코너를 최대한 줄이면서 골 지점까지 경로를 만드는것
- 또 BFS에 DFS를 혼합하려는 시도를 함
- 

## 취약점
- 또 BFS에 DFS를 혼합하려는 시도를 함
  - 코너의 비용 문제로 인해 단순 방문 T/F로 BFS를 접근했을 경우 확인할 수 없는 경우가 있다고 생각하여, 경로의 분기가 일어날 때마다 visited 배열을 깊은 복사하였음 이로인해 시간과 공간 문제 발생
  - 단순 경로의 방문 여부를 visited 배열에 넣을 게 아니고, 이번에 방문했을 경우의 cost를 저장하는 식으로 하면 위의 고민 해결됨

## 코드
```javascript
class Queue {
    constructor() {
        this.arr = [];
        this.front = 0;
        this.rear = 0;
        this.size = 2000000;
    }
    
    isFull() {
        return (this.rear + 1) % this.size === this.front;
    }
    
    isEmpty() {
        return this.rear === this.front;
    }
    
    add(element) {
        if (this.isFull()) {
            return null;
        }
        
        this.arr[this.rear] = element;
        this.rear = (this.rear + 1) % this.size;
    }
    
    poll() {
        const output = this.arr[this.front];
        this.front = (this.front + 1) % this.size;
        return output;
    }
    
    clear() {
        this.arr = [];
        this.front = 0;
        this.rear = 0;
    }
}

function solution(board) {
    
    const dy = [1, 0, -1, 0];
    const dx = [0, 1, 0, -1];
    
    function bfs(startInfo) {
        if (board[startInfo[0][0]][startInfo[0][1]] === 1) return 987654321;
        
        const queue = new Queue();
        const visited = Array.from({length: board.length}, () => Array(board.length).fill(0));
        visited[0][0] = 1;
        visited[startInfo[0][0]][startInfo[0][1]] = 1;
        
        queue.add(startInfo);
        
        let answer = 2147483647;
        
        while(!queue.isEmpty()) {
            const [currPosition, currDirection, currCost] = queue.poll();
        
            if (currPosition[0] === board.length - 1 && currPosition[1] === board.length - 1) {
                answer = Math.min(answer, currCost);
                continue;
            }
        
            for (let i = 0; i < 4; i++) {
                const nextDirection = (currDirection + i) % 4;
                const nextY = currPosition[0] + dy[nextDirection];
                const nextX = currPosition[1] + dx[nextDirection];
                const nextCost = currDirection === nextDirection ? currCost + 100 : currCost + 600;
                
                if (board[nextY] === undefined || board[nextY][nextX] === undefined) continue;
                if (board[nextY][nextX] === 1) continue;
                if (visited[nextY][nextX] !== 0 && nextCost > visited[nextY][nextX]) continue;
            
                visited[nextY][nextX] = nextCost;
                queue.add([[nextY, nextX], nextDirection, nextCost])
            }
        }
        return answer;
    }
    
    return Math.min(bfs([[1, 0], 0, 100]), bfs([[0, 1], 1, 100]));
}


```
