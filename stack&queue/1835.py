#초기 순서를 찾아야 하므로 최종 상태에서 거꾸로 진행
from collections import deque
n = int(input())
card = deque([n])
for i in range(n-1, 0, -1): #역순
    card.appendleft(i) #카드를 가장 앞에 삽입
    for j in range(i):
        card.appendleft(card.pop()) #가장 뒤에 있는 카드를 앞쪽에 추가
for i in range(len(card)):
    print(card[i], end=' ')