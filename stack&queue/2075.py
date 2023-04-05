#메모리 초과 문제
#한 줄씩 입력 받을 때마다 정렬
import sys, heapq
n = int(input())
heap = []
for i in range(n):
    num = list(map(int, sys.stdin.readline().split()))
    if not heap:
        for j in num:
            heapq.heappush(heap, j)
    else:
        for j in num:
            if heap[0] < j:
                heapq.heappush(heap, j)
                heapq.heappop(heap)
print(heap[0])