from collections import deque

n, k = map(int, input().split())
dq = deque([i for i in range(1, n+1)])
ans = []
for i in range(n):
    for i in range(k-1):
        dq.append(dq.popleft())
        #print(dq)
    ans.append(dq.popleft())
print('<', end='')
print(', '.join(map(str, ans)), end='')
print('>')