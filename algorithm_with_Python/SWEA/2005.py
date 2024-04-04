#파스칼의 삼각형
T = int(input())

for test_case in (1, T+1):
    N = int(input())
    dp = [[0 for _ in range(N)] for _ in range(N)]
    dp[0][0] = 1
    print(f"#{test_case}\n{dp[0][0]}")
    for i in range(1, N):
        for j in range(0, i+1):
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            print(dp[i][j], end=' ')
        print()