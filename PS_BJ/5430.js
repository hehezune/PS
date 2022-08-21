//5430
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let T = Number(input[0]);
let lineNumber = 1;
let result = "";

let lineInput = function() {
	if (lineNumber % 3 === 0) {
		let temp = input[lineNumber++];
		temp = temp.slice(1,-1).split(',');
		if (temp[0] === '') {
			return [];
		} else {
			return temp;
		}
	} else {
		return input[lineNumber++];
	}
}

while (T-- > 0) {
	let command = Array.from(lineInput());
	let n = Number(lineInput());
	let sequence = lineInput();
	let direction = 1;
	let sequenceIndex = 0;
	let error = 0;

	for(let i = 0; i < command.length; i++) {
		if (command[i] == 'R') {
			direction *= -1;
		} else if (command[i] == 'D' && direction === 1) {
			if (sequence[sequence.length -1] === -1 || sequence.length === 0) {
				result += "error" + '\n';
				error = 1;
				break;
			}
			sequence[sequenceIndex++] = -1;
		} else {
			if (sequence.length === 0) {
				result += "error" + '\n';
				error = 1;
				break;
			}
			sequence.pop();
		}
	}
	if (error === 0) {
		sequence.splice(0, sequenceIndex);
		if (direction === -1)
			sequence.reverse();
		result += '[' + sequence.join(',') + ']' + '\n';
	}
}
console.log(result);
