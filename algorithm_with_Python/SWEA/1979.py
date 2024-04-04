T = int(input())
for test_case in range(1, T+1):
    N, K = map(int, input().split())
    ans = 0
    board = [input().replace(" ", "") for _ in range(N)]
    #행 확인
    for i in range(N):
        row = board[i].split('0')
        for j in row:
            if len(j) == K:
                ans += 1
    #열 확인
    board = list(zip(*board)) #전치행렬 만들기
    for i in range(N):
        col = ''.join(board[i]).split('0')
        for j in col:
            if len(j) == K:
                ans += 1

    print(f"#{test_case} {ans}")