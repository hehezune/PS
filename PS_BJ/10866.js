//10866
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let N = Number(input[0]);
let index = 1;
let deque = new Deque();
let result = "";
while (N-- > 0) {
    let command = input[index++].trim().split(' ');
    switch (command[0]) {
        case ('push_back'):
            deque.pushBack(command[1]);
            break;
        case ('push_front'):
            deque.pushFront(command[1]);
            break;
        case ('pop_front'):
            result += deque.popFront() + "\n";
            break;
        case ('pop_back'):
            result += deque.popBack() + "\n";
            break;
        case ('front'):
			result += deque.front() + "\n";
			break;
        case ('back'):
            result += deque.back() + "\n";
            break;
        case('size'):
            result += deque.length + "\n";
            break;
        case('empty'):
            result += deque.empty() + "\n";
            break;
    }
}
console.log(result);
function Deque() {
    let head, tail, curr, prev;

    this.length = 0;
    this.size = function() {
        return this.length;
    }
    this.empty = function() {
        if (this.length === 0) {
            return 1;
        } else {
            return 0;
        }
    }
    this.front = function() {
        if (this.length === 0) {
            return -1;
        } else {
            return head.val;
        }
    }
    this.back = function() {
        if (this.length === 0) {
            return -1;
        } else {
            return tail.val;
        }
    }
    this.pushBack = function(val) {
        if (this.length === 0) {
			head = new Node(val);
			tail = head;
		} else if (this.length === 1) {
			let newNode = new Node(val);

			tail = newNode;
			head.next = tail;
			tail.prev = head;
		} else {
            let node = new Node(val);

			tail.next = node;
			node.prev = tail;
			tail = tail.next;

        }
        this.length++;
    }
    this.pushFront = function(val) {
		if (this.length === 0) {
			head = new Node(val);
			tail = head;
		} else if (this.length === 1) {
			let temp = new Node(val);

			temp.next = head;
			head.prev = temp;
			tail = head;
			head = head.prev;
		} else {
			let temp = new Node(val);

			temp.next = head;
			head.prev = temp;
			head = head.prev;
		}
		this.length++;
	}
    this.popBack = function() {
		if (this.length === 0) {
			return -1;
		} else if (this.length === 1) {
			let temp = tail;

			head = tail = null;
			this.length--;
			return temp.val;
		} else {
			let temp = tail;

			tail = tail.prev;
			this.length--;
			return temp.val;
		}
	}
    this.popFront = function() {
		if (this.length === 0) {
			return -1;
		} else {
			let temp = head;

			if (this.length === 1) {
				head = tail = null;
			} else {
				head = head.next;
			}
			this.length--;
			return temp.val;
		}
	}
    function Node(val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
