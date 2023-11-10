import sys
input = sys.stdin.readline

#인덱스드트리
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
    if start > idx or end < idx : #범위에 포함 x -> 교체 안함
        return
    tree[node] += diff
    if start != end :
        mid = (start+end) // 2
        update(2*node, start, mid, idx, diff)
        update(2*node+1, mid+1, end, idx, diff)
    return

N, M, K = map(int, input().split())
tree = [0] * (4*N)
array = list()
for _ in range(N):
    array.append(int(input()))
init(1, 0, N-1) #트리 초기화
for _ in range(M + K) :
    a, b, c = map(int, input().split())
    if a == 1 : # 구간 숫자 바꾸기
        diff = c - array[b-1]
        array[b-1] = c
        update(1, 0, N-1, b-1, diff)
    elif a == 2 : # 구간 합 구하기
        print(sum(1, 0, N-1, b-1, c-1))