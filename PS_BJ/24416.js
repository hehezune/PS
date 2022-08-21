//24416
let fs = require('fs');
let input = fs.readFileSync('testinput')
input = Number(input);
let count = 0;
let fibo = [];
fibo[1] = 1;
fibo[2] = 1;
let answer = case2(input);
console.log(answer, count);

function case2(n) {
	count++;
	if (n <= 2)
		return fibo[n];
	else {
		if (fibo[n - 1] == undefined)
			fibo[n - 1] = case2(n - 1);
		if (fibo[n - 2] == undefined)
			fibo[n - 2] = case2(n - 2);
		fibo[n] = fibo[n - 1] + fibo[n - 2];}
	return fibo[n];
}
