#실패, 주어진 리스트의 순서대로가 아닌 pop된 순서로 몇초에 나왔는지 출력됨
from collections import deque
n = int(input())
dq = deque(map(int, input().split()))
time = []
pizza=1
t=1
while dq:
    for i in range(len(dq)):
        if dq[0] == pizza:
            dq.popleft()
            time.append(t)
            #print(time)
            #print(dq)
        else:
            dq.append(dq.popleft())
        t += 1
    pizza += 1
# for i in range(n):
#     print(time[i-1], end=' ')
print(' '.join(map(str, time)), end=' ')