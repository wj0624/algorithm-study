from itertools import permutations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = set()

for s in permutations(arr, M):
    result.add(s)

for i in sorted(result):
    print(' '.join(map(str, i)))