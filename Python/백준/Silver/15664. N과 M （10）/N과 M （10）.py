from itertools import combinations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = set()

arr.sort()
for s in combinations(arr, M):
    result.add(s)

for i in sorted(result):
    print(' '.join(map(str, i)))