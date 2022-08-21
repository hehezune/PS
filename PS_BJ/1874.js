//1874
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let N = Number(input[0]);
let index = 1;
let stack = [];
let present = 1;
let pushedNumber = 0;
let result = "";

while (index <= N) {
    let target = Number(input[index++]);

    if (present <= target) {
        for (let number = pushedNumber + 1; number <= target; number++) {
            stack.push(number);
            result += "+\n";
            pushedNumber = number;
        }
        result += "-\n";
        stack.pop();
    } else {
        result = "NO";
        break;
    }
    if (stack.length === 0)
        present = 0;
    else
        present = stack[stack.length - 1];
}

console.log(result);