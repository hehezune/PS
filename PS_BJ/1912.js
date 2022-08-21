//1149
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().trim().split('\n');
const N = Number(input[0]);
//let dp = Array.from({length : N}, () => Array.from({length : 3}, () => -1));
let dp = new Array(N).fill(new Array(3).fill(-1));
console.log(dp);

let lineNumber = 2;
//dp[0] = input[1].split(' ').map(Number);
for (let i = 1; i < N; i++) {
	let temp = lineinput();
	dp[i][0] = temp[0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
	dp[i][1] = temp[1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
	dp[i][2] = temp[2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
	console.log(dp);
}
console.log(Math.min(...dp[N - 1]));

function lineinput() {
	return input[lineNumber++].split(' ').map(Number);
}
