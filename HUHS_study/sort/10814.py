import sys

n = int(sys.stdin.readline())
arr = []
for i in range(n):
    age, name = sys.stdin.readline().split()
    arr.append((int(age), name, i)) #age를 int로 받지 않으면 틀림

arr.sort(key = lambda x: (x[0], x[2]))

for i in range(len(arr)):
    print(arr[i][0], arr[i][1])