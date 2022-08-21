//1021
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let [N, M] = input[0].split(' ').map(Number);
let target = input[1].split(' ').map(Number);
let order = Array.from({length : N}, (elem, idx) => idx + 1);
let result = 0;

for (let i = 0; i < M; i++) {
	result += countNumbers(order, target[i]);
}

console.log(result);
function countNumbers(queue, target) {
	let count = 0;
	if (queue.indexOf(target) < queue.length / 2) {
		while (queue.indexOf(target) !== 0) {
			queue.push(queue.shift());
			count++;
		}
	} else {
		while (queue.indexOf(target) !== 0) {
			queue.unshift(queue.pop());
			count++;
		}
	}
	queue.shift();
	return count;
}
