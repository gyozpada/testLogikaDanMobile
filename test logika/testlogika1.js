const a = [10, 20, 20, 10, 10, 30, 50, 10, 20];
const b = [6, 5, 2, 3, 5, 2, 2, 1, 1, 5, 1, 3, 3, 3, 5];
const c = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3];

const ShoePairCount = (input) => {
  let count = 0;
  const set = new Set();
  for (let i = 0; i < input.length; i++) {
    if (set.delete(input[i])) {
      count++;
    } else {
      set.add(input[i]);
    }
  }
  return count;
};

console.log(ShoePairCount(a));
console.log(ShoePairCount(b));
console.log(ShoePairCount(c));
