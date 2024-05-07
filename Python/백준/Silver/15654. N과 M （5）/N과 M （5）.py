from itertools import permutations

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = []

for s in permutations(arr, M):
    result.append(s)

result.sort()

for i in result:
    print(' '.join(map(str, i)))