//17298
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let N = Number(input[0]);
let sequence = input[1].split(' ').map(elem => +elem);

let stack = [];
let result = [];

result[0] = -1;
stack[0] = sequence.pop();
for (let index = N - 2; index >= 0 ; index--) {
    if (sequence[index] < stack[stack.length - 1]) {
        result.push(stack[stack.length - 1]);
    } else {
        while (stack.length && sequence[index] >= stack[stack.length - 1])
            stack.pop();
        if (stack.length == 0)
            result.push(-1);
        else
            result.push(stack[stack.length - 1]);
    }
    stack.push(sequence.pop());

}

result = result.reverse();
console.log(result.join(' '));


const list = [1,2,3,4];

const nextList = list.map(id => id !== 1);


console.log(nextList);

