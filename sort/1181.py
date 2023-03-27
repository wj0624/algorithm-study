import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n):
    arr.append(sys.stdin.readline().strip())
arr=list(set(arr)) #중복 제거
arr.sort(key=lambda x:(len(x),x)) #정렬 with length
for i in range(len(arr)):
    print(arr[i])