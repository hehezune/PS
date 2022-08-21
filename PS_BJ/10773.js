//10773
let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().split('\n');
let K = Number(input.shift());

let moneys = [];
/*
while (K-- > 0) {
    let temp = Number(input.shift());
    if (temp === 0)
        moneys.pop();
    else 
        moneys.push(temp);
}*/
let i = 0;
while (i < K) {
    let temp = Number(input[i++]);

    if (temp === 0)
        moneys.pop();
    else   
        moneys.push(temp);
}
console.log(moneys.reduce((acc, curr) => acc + curr, 0));