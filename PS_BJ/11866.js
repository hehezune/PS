//11866
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split(' ').map(x => +x);
let result = "<";

let people = new LinkedList();
for (let i = 1; i <= input[0]; i++)
	people.append(i);
//	people.showEntire();

while (people.length != 1) {
	people.moveTo(input[1]);
	result += people.showCurrent() + ", ";
	people.removeCurrent();
	people.showEntire();
}
result += people.showCurrent() + ">";
console.log(result);

function LinkedList() {
	let head, previous = null;
	let tail, current;
	function Node(elem) {
		this.val = elem;
		this.next = null;
	}
	this.length = 0;
	this.append = function(val) {
		if (this.length === 0) {
			head = new Node(val);
			current = head;
			this.length = 1;
			tail = head;
		} else {
			let newNode = new Node(val);
			tail.next = newNode;
			tail = tail.next;
			tail.next = head;
			previous = tail;
			this.length++;
		}
	}
	this.moveTo = function(distance) {
		while (distance-- > 1) {
			previous = current;
			current = current.next;
		}
	}
	this.removeCurrent = function() {
		current = current.next;
		previous.next = current;
		this.length--;
	}
	this.showCurrent = function() {
		console.log(current.val);
		return current.val;
	}
	this.showEntire = function() {
		let temp = "";
		let tempDistance = this.length;
		while (tempDistance-- > 0) {
			temp += current.val + " ";
			this.moveTo(2);
		}
		console.log(temp);
	}
}

result += ">"
