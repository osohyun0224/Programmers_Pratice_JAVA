const weights = [
  [1, 7, 6, 7, 5, 4, 5, 3, 2, 3],
  [7, 1, 2, 4, 2, 3, 5, 4, 5, 6],
  [6, 2, 1, 2, 3, 2, 3, 5, 4, 5],
  [7, 4, 2, 1, 5, 3, 2, 6, 5, 4],
  [5, 2, 3, 5, 1, 2, 4, 2, 3, 5],
  [4, 3, 2, 3, 2, 1, 2, 3, 2, 3],
  [5, 5, 3, 2, 4, 2, 1, 5, 3, 2],
  [3, 4, 5, 6, 2, 3, 5, 1, 2, 4],
  [2, 5, 4, 5, 3, 2, 3, 2, 1, 2],
  [3, 6, 5, 4, 5, 3, 2, 4, 2, 1],
];

const solution = (numbers) => {
  const DP = Array.from({ length: numbers.length + 1 }, () =>
    Array.from({ length: 10 }, () => new Array(10).fill(Infinity))
  );

  DP[0][4][6] = 0;

  for (let idx = 0; idx < numbers.length; idx += 1) {
    const num = numbers[idx];

    const prevDP = DP[idx];
    const nowDP = DP[idx + 1];

    for (let i = 0; i < 10; i += 1) {
      for (let j = 0; j < 10; j += 1) {
        const prevValue = prevDP[i][j];
        if (i === j || prevValue === Infinity) continue;
        
        if (nowDP[num][j] > prevValue + weights[i][num]) {
            nowDP[num][j] = prevValue + weights[i][num]
        }
          
        if (nowDP[i][num] > prevValue + weights[num][j]) {
            nowDP[i][num] = prevValue + weights[num][j]
        }
      }
    }
  }

  return Math.min(...DP[numbers.length].flat().flat());
};