from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())
p = deque(map(int, sys.stdin.readline().split())) #위치
dq = deque([i for i in range(1, n+1)])
cnt = 0

for i in p:
    while 1:
        if dq[0]==i:
            dq.popleft()
            break
        else:
            if dq.index(i) <= len(dq)//2:   #해당 위치가 반보다 작을 때(앞쪽에 더 가까움)
                dq.rotate(-1)   #왼쪽으로 한칸 이동
                cnt+=1
            else:
                dq.rotate(1)    #오른쪽으로 한칸 이동
                cnt+=1
print(cnt)