from itertools import combinations_with_replacement

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = set()

arr.sort()
for s in combinations_with_replacement(arr, M):
    result.add(s)

for i in sorted(result):
    print(' '.join(map(str, i)))