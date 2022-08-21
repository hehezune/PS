//15650
//let fs = require('fs');
//let input = fs.readFileSync('testinput').toString().split(' ').map(elem => +elem);
//let [n, m] = [input[0], input[1]];
let [n, m] = [9, 6];
let totalResult = [];
let sequence = [];

makeSequence(n, m, 0, 1);
console.log(totalResult.join('\n'));

function makeSequence(maxNumb , totalNumb, index, numb) {
    if (index == m) {
        totalResult.push(sequence.join(' '));
    } else {
        for (let i = numb; i <= maxNumb; i++) {
            sequence.push(i);
            makeSequence(maxNumb, totalNumb, index + 1, i + 1);
            sequence.pop();
        }
    }
}