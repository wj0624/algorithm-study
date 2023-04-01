import sys
import heapq

n = int(input())
heap = []
for i in range(n):
    x = int(sys.stdin.readline())
    if x > 0:
        heapq.heappush(heap, x)
    elif x == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
'''
[참고링크]
- 자료구조 heap 이란 : https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
- heapq 모듈 사용 : https://littlefoxdiary.tistory.com/3
'''