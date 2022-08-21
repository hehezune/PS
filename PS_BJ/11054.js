//11054
let fs = require('fs').readFileSync('testinput').toString().trim()
.split('\n');
let N = +fs[0];
let sequence = fs[1].split(' ').map(Number);

let front = [1];
let back = [];
back[N - 1] = 1;

for (let i = 1; i < N; i++) {
	front[i] = 0;
	for (let j = 0; j < i; j++) {
		if (sequence[i] > sequence[j])
			front[i] = Math.max(front[i], front[j])
	}
	front[i]++;
}
for (let i = N - 2; i >= 0; i--) {
	back[i] = 0;
	for (let j = N - 1; j > i; j--) {
		if (sequence[i] > sequence[j])
			back[i] = Math.max(back[i], back[j]);
	}
	back[i]++;
}

let dp = Array.from({length : N}, (v, i) => (front[i] + back[i]));
console.log(Math.max(...dp) - 1);
