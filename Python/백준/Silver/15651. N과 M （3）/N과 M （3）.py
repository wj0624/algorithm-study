from itertools import product

N, M = map(int, input().split())
arr = []

for s in product(range(1, N+1), repeat=M):
    arr.append(' '.join(map(str, s)))

print('\n'.join(arr))