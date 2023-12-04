function solution(keymap, targets) {

    let mapOfKeys = new Map();
    keymap.forEach((word) => {
        for (let i = 0; i < word.length; i++) {
            if (!mapOfKeys.has(word[i])) {
                mapOfKeys.set(word[i], i);
                continue;
            }
            mapOfKeys.set(word[i], Math.min(i, mapOfKeys.get(word[i])));
        }
    })
    
    let answer = targets.map((word) => {
        let count = 0;
        for (let i = 0; i < word.length; i++) {
            if (!mapOfKeys.has(word[i])) {
                return -1;
            }
            count += mapOfKeys.get(word[i]) + 1;
        }
        return count;
    })
    return answer;
}