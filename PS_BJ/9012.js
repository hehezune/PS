//9012
let fs = require('fs');
let input = fs.readFileSync('testinput').toString().split('\n');
let T = Number(input[0]);
let result = "";

for (let i = 1; i <= T; i++) {
    let lineInput = input[i];
    let stack = [];
    let index = 0, length = lineInput.length;

    while (index < length) {
        if (lineInput[index] == '(')
            stack.push('(');
        else if (lineInput[index] == ')') {
            if (stack.length === 0) {
                stack[0] = '0';
                break;
            }
            stack.pop();
        }
        index++;
    }
    if (stack.length === 0)
        result += "YES" + '\n';
    else 
        result += "NO" + '\n';
}

console.log(result);