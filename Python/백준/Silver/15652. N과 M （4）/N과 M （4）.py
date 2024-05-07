from itertools import combinations_with_replacement

N, M = map(int, input().split())
arr = []

for s in combinations_with_replacement(range(1, N+1), M):
    arr.append(' '.join(map(str, s)))

print('\n'.join(arr))