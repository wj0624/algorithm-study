#메모리 초과 문제
#한 줄씩 입력 받을 때마다 정렬
import sys, heapq
n = int(input())
heap = []
for i in range(n):
    num = list(map(int, sys.stdin.readline().split()))
    if not heap: #첫번째 입력
        for j in num:
            heapq.heappush(heap, j)
            print(heap)
    else:
        for j in num: #항상 길이 n만큼 유지
            if heap[0] < j: #최소값 보다 클 때
                heapq.heappush(heap, j) #push
                heapq.heappop(heap) #최소값은 pop
print(heap[0])