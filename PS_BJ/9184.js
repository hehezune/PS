//9184
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().trim().split('\n');
let arrayW = Array.from({length : 21}, () => Array.from({length : 21},
	() => Array.from({length : 21}, () => -1)));
let lineNumber = 0;
let result = "";
while (true) {
	let inputW = lineInput();
	if (typeof(inputW) !== 'object') {
		break;
	} else {
		let temp = calArrayW(inputW[0], inputW[1], inputW[2]);
		result += `w(${inputW[0]}, ${inputW[1]}, ${inputW[2]}) = ${temp}\n`;
	}
}
console.log(result);
function lineInput() {
	let temp = input[lineNumber++].split(' ').map(Number);
	if (temp[0] === -1 && temp[1] === -1 && temp[2] === -1) {
		return false;
	} else {
		return temp;
	}
}

function calArrayW(a, b, c) {
	if (a <= 0 || b <= 0 || c <= 0) {
		return 1;
	} else if (a > 20 || b > 20 || c > 20) {
		a = b = c = 20;
	}
	if (arrayW[a][b][c] != -1)
		return arrayW[a][b][c];
	if (a < b && b < c) {
		arrayW[a][b][c] = calArrayW(a, b, c - 1) + calArrayW(a, b - 1, c - 1) - calArrayW(a, b - 1, c);
	} else	{
		arrayW[a][b][c] = calArrayW(a - 1, b, c) + calArrayW(a - 1, b - 1, c) + calArrayW(a - 1, b, c - 1) - calArrayW(a - 1, b - 1, c - 1);
	}
	return arrayW[a][b][c];
}
