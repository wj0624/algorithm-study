#평균의 평균
from itertools import combinations

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    S = list(map(int, input().split()))
    sub = []
    # 모든 부분집합 구하기
    for i in range(1, n + 1):
        sub = sub + list(combinations(S, i))

    # 각 부분집합의 평균 구하기
    avg = 0
    for i in sub:
        avg += sum(i) / len(i)

    ans = avg / (2 ** n - 1)
    if ans.is_integer():
        print(f"#{test_case} {ans:.0f}")
    else:
        print(f"#{test_case} {ans:.20f}")