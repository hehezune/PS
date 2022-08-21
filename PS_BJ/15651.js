//15651
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ').map(elem => +elem);
let [n, m] = [input[0], input[1]];

let totalResult = [];
let sequence = [];

makeSequence(0);
console.log(totalResult.join('\n'));

function makeSequence(index) {
    if (index == m) {
        totalResult.push(sequence.join(' '));
    } else {
        for (let numb = 1; numb <= n; numb++) {
            sequence.push(numb);
            makeSequence(index + 1);
            sequence.pop();
        }
    }
}