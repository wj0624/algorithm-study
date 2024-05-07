from itertools import combinations

N, M = map(int, input().split())
arr = []

for s in combinations(range(1, N+1), M):
    arr.append(' '.join(map(str, s)))

print('\n'.join(arr))