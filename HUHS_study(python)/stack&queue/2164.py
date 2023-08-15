#시간초과 문제 발생
#list = O(N), deque = O(1)
#collections 모듈의 deque 자료구조 활용
from collections import deque

n = int(input())
card = deque(range(1, n+1)) #queue에 1 ~ n까지 순서대로 add
for i in range(n-1):
    card.popleft()  #popleft: 가장 왼쪽 요소 반환 및 삭제
    card.append(card.popleft()) #append: 오른쪽 끝에 삽입
#print(card)
print(card[0])

#참고 사이트: https://codingpractices.tistory.com/entry/Python%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%99%9C-%EB%A6%AC%EC%8A%A4%ED%8A%B8%EB%8C%80%EC%8B%A0-%ED%81%90-%EB%8D%B0%ED%81%AC-deque-%EB%A5%BC-%EC%93%B8%EA%B9%8C