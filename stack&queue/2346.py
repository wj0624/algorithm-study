from collections import deque

n= int(input())
#enumerate 사용 시 index와 원소 tuple 형태로 반환
dq = deque(enumerate(map(int, input().split())))
ans = []
while dq:
    index, paper = dq.popleft()
    ans.append(index+1)
    if paper > 0:
        dq.rotate(-(paper-1))
    elif paper < 0:
        dq.rotate(-paper)
for i in ans:
    print(i, end=' ')