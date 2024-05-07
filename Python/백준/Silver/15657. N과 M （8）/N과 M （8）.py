from itertools import combinations_with_replacement

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = []

arr.sort()
for s in combinations_with_replacement(arr, M):
    result.append(s)

for i in result:
    print(' '.join(map(str, i)))