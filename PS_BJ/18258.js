//18258
const fs = require('fs');
const input = fs.readFileSync('testinput').toString().split('\n');
const N = Number(input[0]);
const lineInput = function() {
    return input[lineNumber++].toString().split(' ');
}
let lineNumber = 1;
let result = "";
let queue = new Queue();
while (lineNumber <= N) {
    let command = lineInput();
    switch (command[0]) {
        case "push" :
            queue.push(command[1]);
            break;
        case "pop" :
            queue.pop();
            break;
        case "size" :
            queue.size();
            break;
        case "empty" :
            queue.empty();
            break;
        case "front" :
            queue.front();
            break;
        case "back" :
            queue.back();
            break;
    }
}
console.log(result);

function Queue() {
    function ListNode(val, next) {
        this.val = (val === undefined ? 0 : val);
        this.next = (next === undefined ? null : next);
    }
    let tail = new ListNode();
    let head = new ListNode(0, tail);
    let length = 0;

    this.push = function(elem) {
        if (length === 0)
            tail.val = elem;
        else {
            let node = new ListNode(elem);
            tail.next = node;
            tail = tail.next;
        }
        length++;
        this.allsee();
    }
    this.pop = function() {
        if (length === 0) {
            result += '-1' + '\n';
            tail = new ListNode();
            head.next = tail;
        } else if (length === 1) {
            result += head.next.val + "\n";
            head = head.next;
            let node = new ListNode();
            tail = node;
            head.next = tail;
            length--;
        } else
        {
            result += head.next.val + "\n";
            head = head.next;
            length--;
        }
        this.allsee();
    }
    this.size = function() {
        result += length + "\n";
        this.allsee();
    }
    this.empty = function() {
        if (length === 0)
            result += '1' + '\n';
        else
            result += '0' + '\n';
        this.allsee();
    }
    this.front = function() {
        if (length === 0)
            result += "-1" + '\n';
        else
            result += head.next.val + "\n";
        this.allsee();
    }
    this.back = function() {
        if (length === 0)
            result += '-1' + '\n';
        else
            result += tail.val + '\n';
        this.allsee();
    }
    this.allsee = function() {
        let test = head.next;
        let arr = [];
        while (test) {
            arr.push(test.val);
            test = test.next;
        }
        console.log("test", arr, head, length);
    }
}
