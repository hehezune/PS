//2164
let fs = require('fs');
let input = fs.readFileSync('testinput').toString();
input = Number(input);

function Queue() {
	let head = new Node(0);
	let current = head;
	this.length = 0;

	function Node(elem, next) {
		this.val = (elem == undefined ? 0 : elem);
		this.next = (next == null ? null : next);
	}
	this.push = function(elem) {
		let newNode = new Node(elem);
		current.next = newNode;
		current = current.next;
		this.length++;
	}
	this.shift = function() {
		let shiftValue = head.next.val;
		head = head.next;
		this.length--;
		return shiftValue;
	}
	this.getHead = function() {
		return current.val;
    }
}

let queue = new Queue();
for (let index = 1; index <= input; index++)
	queue.push(index);

while(queue.length != 1) {
	queue.shift();
	queue.push(queue.shift());
}
console.log(queue.getHead());
