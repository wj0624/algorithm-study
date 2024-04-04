def comb(start, sel):
    memo = [start,]
    select = sel
    for i in range(1, N):
        if comp1[i] > comp2[i]:  # 1번 비료 높이가 더 크면
            if select == 1:  # 이전 비료가 1이면
                if comp2[i] > comp1[i] - P:  # 2번, 1번-P 둘 중 큰 값 선택
                    memo.append(comp2[i])
                    select = 2
                else:
                    memo.append(comp1[i] - P)
                    select = 1
            else:
                memo.append(comp1[i])
                select = 1
        else:
            if select == 2:
                if comp1[i] > comp2[i] - P:  # 1번, 2번-P 둘 중 큰 값 선택
                    memo.append(comp1[i])
                    select = 1
                else:
                    memo.append(comp2[i] - P)
                    select = 2
            else:
                memo.append(comp2[i])
                select = 2
    return memo

T = int(input())

for test_case in range(1, T+1):
    N, P = map(int, input().split())
    comp1 = list(map(int, input().split()))
    comp2 = list(map(int, input().split()))
    ans = 0
    select = 0  # 이전에 준 비료 번호
    arr = []
    arr.append(comb(comp1[0], 1))
    arr.append(comb(comp2[0], 2))
    for i in range(len(arr)):
        ans = max(ans, sum(arr[i]))

    print(f"#{test_case} {ans}")

    '''N, P = map(int, input().split())
    comp1 = list(map(int, input().split()))
    comp2 = list(map(int, input().split()))
    ans = 0
    select = 0 #이전에 준 비료 번호
    for i in range(N):
        if comp1[i] > comp2[i]: #1번 비료 높이가 더 크면
            if select == 1 : #이전 비료가 1이면
                if comp2[i] > comp1[i]-P: #2번, 1번-P 둘 중 큰 값 선택
                    ans += comp2[i]
                    select = 2
                else :
                    ans += comp1[i]-P
                    select = 1
            else :
                ans += comp1[i]
                select = 1
        else:
            if select == 2 :
                if comp1[i] > comp2[i] - P: #1번, 2번-P 둘 중 큰 값 선택
                    ans += comp1[i]
                    select = 1
                else:
                    ans += comp2[i] - P
                    select = 2
            else :
                ans += comp2[i]
                select = 2

    print(f"#{test_case} {ans}")'''