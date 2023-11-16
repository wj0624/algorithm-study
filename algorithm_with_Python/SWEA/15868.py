T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    arr = [list(map(int, input())) for _ in range(n)]
    ans = 0
    for i in range(n-1):
        for j in range(m):
            if arr[i][j] == arr[i+1][j]:
                ans = 1
    if ans :
        print(f"#{test_case} no")
    else :
        print(f"#{test_case} yes")