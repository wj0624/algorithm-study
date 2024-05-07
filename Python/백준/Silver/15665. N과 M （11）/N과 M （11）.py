from itertools import product

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = set()

arr.sort()
for s in product(arr, repeat=M):
    result.add(s)

for i in sorted(result):
    print(' '.join(map(str, i)))