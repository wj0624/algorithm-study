#인덱스드트리
import sys
#input = sys.stdin.readline

sys.stdin=open("input.txt","r")

def init(node, start, end):
    if start == end :
        tree[node] = array[start]
        return tree[node]
    mid = (start + end) // 2
    tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end)
    return tree[node]

# node 담당 : start ~ end, 합 구간 : left ~ right
def sum(node, start, end, left, right):
    if left>end or right<start: #찾고자하는 범위 x
        return 0
    elif left<=start and end<=right : #찾고자하는 범위가 포함, 그대로 리턴(자식 노드 안봄)
        return tree[node]
    else :
        mid = (start+end) // 2
        return sum(2*node, start, mid, left, right) + sum(2*node+1, mid+1, end, left, right)

def update(node, start, end, idx, diff):
    if start > idx or end < idx :
        return
    tree[node] += diff
    if start != end :
        mid = (start+end) // 2
        update(2*node, start, mid, idx, diff)
        update(2*node+1, mid+1, end, idx, diff)
    return

N, M, K = map(int, sys.stdin.readline().split())
tree = [0] * (4*N)
array = list()
for _ in range(N):
    array.append(int(sys.stdin.readline()))
init(1, 0, N-1) #트리 초기화
for _ in range(M + K) :
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1 : # 구간 숫자 바꾸기
        diff = c - array[b-1]
        array[b-1] = c
        update(1, 0, N-1, b-1, diff)
    elif a == 2 : # 구간 합 구하기
        print(sum(1, 0, N-1, b-1, c-1))

'''-----------------------------------------------------'''
# 퀵정렬
def quick_sort(arr):
    # 리스트 내 원소가 1개인 경우 함수 종료
    if len(arr) <= 1:
        return arr

    # 첫 번째 원소를 피벗으로 설정
    pv = arr[0]
    # 피벗을 제외한 리스트
    tail = arr[1:]

    # 분할된 좌측 리스트
    left_list = [x for x in tail if x <= pv]
    # 분할된 우측 리스트
    right_list = [x for x in tail if x > pv]

    # 분할 이후 좌측 및 우측 리스트 각각에 대해 퀵 정렬 수행
    return quick_sort(left_list) + [pv] + quick_sort(right_list)


print(quick_sort(arr))

'''-----------------------------------------------------'''
# Merge Sort
def merge(arr, low, high):
    temp = []
    mid = (low + high) // 2
    i, j = low, mid + 1

    while i <= mid and j <= high:
        if arr[i] <= arr[j]:
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    while i <= mid:
        temp.append(arr[i])
        i += 1

    while j <= high:
        temp.append(arr[j])
        j += 1

    for k in range(low, high + 1):
        arr[k] = temp[k - low]
    return arr


def merge_sort(arr, low, high):
    if (low >= high):
        return  # base case

    mid = (low + high) // 2

    merge_sort(arr, low, mid)
    merge_sort(arr, mid + 1, high)
    sorted_array = merge(arr, low, high)

    return sorted_array

'''-----------------------------------------------------'''
# 다익스트라 – 최단거리(하나 to 모두)
import heapq

n, m = map(int, input().split())
# 시작 정점의 번호
k = int(input())
# 무한을 의미하는 INF
INF = int(1e9)

graph = [[] * (n + 1) for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            # 경유가 더 빠른경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
dijkstra(k)

'''-----------------------------------------------------'''
# 플로이드 워셜 – 최단거리(모두 to 모두)
graph = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            graph[i][j] = 0
for _ in range(m):
    a, b, c = map(int, input().split())
    if graph[a][b] > c:
        graph[a][b] = c
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
'''-----------------------------------------------------'''

# 파스칼의 삼각형(조합)
for i in range(30):
    for j in range(30):
        if i == 1:
            dp[i][j] = j
        else:
            if i == j:
                dp[i][j] = 1
            elif i < j:
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
'''-----------------------------------------------------'''

# 이진탐색
def binary_search(target, data):
    data.sort()
    start = 0
    end = len(data) - 1
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return mid
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return
'''-----------------------------------------------------'''

# MST(unionfind + PQ) 최소비용 크루스칼
def find(x):
    if parent[x] == x:
        return x
    return parent[x] = find(parent[x])


def union(a, b):
    a = find(a)
    b = find(b)
    if b < a:
        parent[a] = b
    else:
        parent[b] = a


n = int(input())
m = int(input())
arr = []
parent = [i for i in range(n + 1)]
res = 0
for i in range(m):
    a, b, c = map(int, input().split())
    arr.append((
        c,
        a,
        b,
    ))

arr.sort(key=lambda x: x[0])
for dis, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        res += dis
print(res)

'''-----------------------------------------------------'''
# 최대공약수 – 유클리드 호제
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


# 최소공배수
def lcm(a, b):
    return a * b / gcd(a, b)

'''-----------------------------------------------------'''
# 최소공통조상
sys.setrecursionlimit(10 ** 5)  # 재귀 깊이 설정
LOG = 21  # 2^20 = 1,000,000
n = int(input())
parent = [[0] * LOG for _ in range(n + 1)]
d = [0] * (n + 1)
c = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(x, depth):
    c[x] = True
    d[x] = depth

    for y in graph[x]:
        if c[y]:
            continue
        parent[y][0] = x
        dfs(y, depth + 1)


def set_parent():
    dfs(1, 0)
    for i in range(1, LOG):
        for j in range(1, n + 1):
            parent[j][i] = parent[parent[j][i - 1]][i - 1]


def lca(a, b):
    if d[a] > d[b]:
        a, b = b, a
    for i in range(LOG - 1, -1, -1):
        if d[b] - d[a] >= (1 << i):
            b = parent[b][i]
    if a == b:
        return a
    for i in range(LOG - 1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    return parent[a][0]


set_parent()
m = int(input())
for i in range(m):
    a, b = map(int, input().split())
    print(lca(a, b))

'''-----------------------------------------------------'''

# 위상정렬(게임개발)
import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
building = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)
cost = [0] * (N + 1)

for i in range(1, N + 1):
    data = list(map(int, input().split()))[:-1]
    cost[i] = data[0]
    building_data = data[1:]

    for j in building_data:
        building[j].append(i)
        indegree[i] += 1


def topology_sort():
    result = [0] * (N + 1)
    q = deque()

    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        # '선수 건물 짓는데 걸리는 시간 + 현재 건물 짓는데 걸리는 시간'이 저장됨
        result[now] += cost[now]
        for b in building[now]:
            indegree[b] -= 1
            result[b] = max(result[b], result[now])
            if indegree[b] == 0:
                q.append(b)
    return result


answer = topology_sort()
for i in range(1, N + 1):
    print(answer[i])
'''-----------------------------------------------------'''

# 내려가기 (DP)
from sys import stdin

N = int(input())
arr = list(map(int, stdin.readline().split()))
maxDP = arr
minDP = arr
for _ in range(N - 1):
    arr = list(map(int, stdin.readline().split()))

    maxDP = [arr[0] + max(maxDP[0], maxDP[1]), arr[1] + max(maxDP), arr[2] + max(maxDP[1], maxDP[2])]
    minDP = [arr[0] + min(minDP[0], minDP[1]), arr[1] + min(minDP), arr[2] + min(minDP[1], minDP[2])]

print(max(maxDP), min(minDP))
'''-----------------------------------------------------'''

# NQueen (DFS BackTracking)
def backTracking(rowPos):
    global answer
    if rowPos == n:
        answer += 1
        return
    for col in range(n):
        flag = True
        for row in range(rowPos):
            if queenLocation[row] == col or rowPos - row == abs(col - queenLocation[row]):
                flag = False
                break
        if flag:
            queenLocation[rowPos] = col
            backTracking(rowPos + 1)


n = int(input())
answer = 0
queenLocation = [0] * n
backTracking(0)
print(answer)
'''-----------------------------------------------------'''

# 치킨배달
import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
city = list(list(map(int, input().split())) for _ in range(n))
result = 999999
house = []  # 집의 좌표
chick = []  # 치킨집의 좌표

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append([i, j])
        elif city[i][j] == 2:
            chick.append([i, j])

for chi in combinations(chick, m):  # m개의 치킨집 선택
    temp = 0  # 도시 치킨거리
    for h in house:
        chi_len = 999  # 각 집 치킨거리
        for j in range(m):
            chi_len = min(chi_len, abs(h[0] - chi[j][0]) + abs(h[1] - chi[j][1]))
        temp += chi_len
    result = min(result, temp)
print(result)
'''-----------------------------------------------------'''

# 카드놓기 (순열)
from itertools import permutations

n = int(input())
k = int(input())
cards = []
for _ in range(n):
    card = input()
    cards.append(card)
result = set()
for i in permutations(cards, k):
    result.add(''.join(i))
print(len(result))
'''-----------------------------------------------------'''

# 계단 오르기
n = int(input())  # 계단 개수
s = [int(input()) for _ in range(n)]  # 계단 리스트
dp = [0] * (n)  # dp 리스트
if len(s) <= 2:  # 계단이 2개 이하일땐 그냥 다 더해서 출력
    print(sum(s))
else:  # 계단이 3개 이상일 때
    dp[0] = s[0]  # 첫째 계단
    dp[1] = s[0] + s[1]  # 둘째 계단
    for i in range(2, n):  # 3번째 계단 부터 dp 점화식 이용해서 최대값 구하기
        dp[i] = max(dp[i - 3] + s[i - 1] + s[i], dp[i - 2] + s[i])
    print(dp[-1])
'''-----------------------------------------------------'''


# 행렬 곱셈 순서
import sys

N = int(input())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dp = [[0] * (N) for _ in range(N)]

for term in range(1, N):
    for start in range(N):
        if start + term == N:
            break
        dp[start][start + term] = int(1e9)

        for t in range(start, start + term):
            dp[start][start + term] = min(dp[start][start + term],
                                          dp[start][t] + dp[t + 1][start + term] + arr[start][0] * arr[t][1] *
                                          arr[start + term][1])

print(dp[0][N - 1])
'''-----------------------------------------------------'''

# 가장 큰 정사각형
Y, X = map(int, input().split())
graph = []
for _ in range(Y):
    graph.append(list(map(int, list(input()))))
result = 0

for i in range(Y):
    for j in range(X):
        if i > 0 and j > 0 and graph[i][j] == 1:
            graph[i][j] += min(graph[i][j - 1], graph[i - 1][j], graph[i - 1][j - 1])
        result = max(result, graph[i][j])
print(result * result)
'''-----------------------------------------------------'''

# 타임머신(벨만포드)
import sys

input = sys.stdin.readline
INF = int(1e9)


def bellman_ford(start):
    dist[start] = 0
    for i in range(1, n + 1):
        for j in range(m):
            now, next, cost = edges[j][0], edges[j][1], edges[j][2]
            if dist[now] != INF and dist[next] > dist[now] + cost:
                dist[next] = dist[now] + cost
                if i == n:
                    return True
    return False


n, m = map(int, input().split())
edges = []
dist = [INF] * (n + 1)
for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))
negative_cycle = bellman_ford(1)
if negative_cycle:
    print(-1)
else:
    for i in range(2, n + 1):
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])
'''-----------------------------------------------------'''

# 에라토스테네스의 체(소수 구하기)
import math

n = 1000  # 2부터 1,000까지의 모든 수에 대하여 소수 판별
array = [True for i in range(n + 1)]  # 처음엔 모든 수가 소수(True)인 것으로 초기화

# 에라토스테네스의 체 알고리즘
for i in range(2, int(math.sqrt(n)) + 1):  # 2부터 n의 제곱근까지의 모든 수를 확인하며
    if array[i] == True:  # i가 소수인 경우 (남은 수인 경우)
        # i를 제외한 i의 모든 배수를 지우기
        j = 2
        while i * j <= n:
            array[i * j] = False
            j += 1

# 모든 소수 출력
for i in range(2, n + 1):
    if array[i]:
        print(i, end=' ')
'''-----------------------------------------------------'''
