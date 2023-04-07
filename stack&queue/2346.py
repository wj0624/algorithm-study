from collections import deque

n= int(input())
#enumerate 사용 시 index와 원소 tuple 형태로 반환
dq = deque(enumerate(map(int, input().split())))
ans = []
print(dq)
while dq:
    index, paper = dq.popleft() #순서대로 풍선의 번호와 종이에 적힌 값을 반환
    ans.append(index+1) #index가 0부터 시작하므로 +1을 해서 추가해준다
    if paper > 0:
        dq.rotate(-(paper-1)) #이미 풍선이 popleft를 했기 때문에 왼쪽으로 한칸씩 회전되어 있으므로 paper-1만큼 회전
    elif paper < 0:
        dq.rotate(-paper)
for i in ans:
    print(i, end=' ')