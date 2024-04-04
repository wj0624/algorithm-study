def dfs(cnt):
    global ans
    if cnt==n:
        ans = max(ans, int(''.join(num)))
        return
    #숫자 2개 뽑아서 교환하는 모든 조합
    for i in range(len(num)-1):
        for j in range(i+1, len(num)):
            num[i], num[j] = num[j], num[i]
            key = int(''.join(num))
            if (cnt, key) not in v: #이미 방문 했다면
                dfs(cnt+1)
                v.append((cnt, key))
            num[i], num[j] = num[j], num[i]


T = int(input())

for test_case in range(1, T+1):
    num, n = input().split()
    num = list(num)
    n = int(n)
    ans = 0
    v = []
    dfs(0)
    print(f"#{test_case} {ans}")