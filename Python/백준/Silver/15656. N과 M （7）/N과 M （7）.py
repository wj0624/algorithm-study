from itertools import product

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = []

arr.sort()
for s in product(arr, repeat=M):
    result.append(s)

for i in result:
    print(' '.join(map(str, i)))