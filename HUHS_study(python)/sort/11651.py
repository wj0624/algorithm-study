import sys

n = int(sys.stdin.readline())
arr = []
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    arr.append((x,y))

# sort 옵션 : (key = lambda x(x[1],x[0])) -> 두번째값 기준 정렬, 값 같으면 첫번째값 기준
arr.sort(key = lambda x:(x[1], x[0]))

for i in range(len(arr)):
    print(arr[i][0],arr[i][1])