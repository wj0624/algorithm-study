import sys
import heapq

#heapq 모듈은 기본적으로 최소 힙으로 구현되어 있음
max_heap = []
n = int(input())

for i in range(n):
    x = int(sys.stdin.readline())
    if x > 0:
        heapq.heappush(max_heap, -x) #부호를 반대로 넣어주면 최대 힙 구현 가능
    elif x == 0:
        if max_heap:
            print(-heapq.heappop(max_heap)) #출력 시 앞에 -를 붙여주어야 함
        else:
            print(0)