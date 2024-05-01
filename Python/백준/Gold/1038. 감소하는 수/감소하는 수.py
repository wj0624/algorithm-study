from itertools import combinations

n = int(input())
arr = []

if n < 10: # 한자릿수는 무조건 자기 자신
    print(n)
    exit(0)

for i in range(1, 11):
    for j in combinations(range(10), i):
        num = ''.join(map(str, (reversed(list(j)))))
        arr.append(int(num))

arr.sort()
if n >= len(arr):
    print(-1)
else:
    print(arr[n])