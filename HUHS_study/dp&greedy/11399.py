import sys

n = int(sys.stdin.readline())
time = list(map(int, sys.stdin.readline().split()))
ans = 0

time.sort() #오름차순 정렬

for i in range(n):
    for j in range(i+1):
        ans += time[j]
print(ans)