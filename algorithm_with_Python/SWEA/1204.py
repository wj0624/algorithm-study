# 최빈값 구하기
from collections import Counter
T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = list(map(int, input().split()))
    cnt = Counter(arr)
    mode = cnt.most_common(1)
    print(f"#{test_case} {mode[0][0]}")

'''
#재귀 이용
T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    arr = list(map(int, input().split()))
    count = [0] * 101
    #점수별 개수 카운트
    for i in arr:
        count[i] += 1
    cnt = 0
    for i in range(len(count)):
        if count[i] >= cnt:
            mode = i
            cnt = count[i]
    print(f"#{test_case} {mode}")
'''
