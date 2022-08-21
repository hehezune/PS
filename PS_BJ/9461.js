//9461
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().trim().split('\n');
let T = Number(input[0]);
let index = 1;
let sequence = [1, 1, 1];
let result = "";

while (index <= T)
{
	let number = Number(input[index++]);
	result += calAnswer(number - 1) + "\n";
}

console.log(result);

function calAnswer(n) {
	if (n < 3)
		return sequence[n];
	if (sequence[n - 2] === undefined)
		sequence[n - 2] = calAnswer(n - 2);
	if (sequence[n - 3] === undefined)
		sequence[n - 3] = calAnswer(n - 3);
	return sequence[n] = sequence[n - 2] + sequence[n - 3];
}
