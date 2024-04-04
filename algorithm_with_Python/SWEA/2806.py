#NQueen
def backTracking(rowPos):
    global ans
    if rowPos == n: #n-1행까지 검사 완료
        ans += 1
        return
    for col in range(n):
        flag = True
        for row in range(rowPos):
            #1) 같은 열 불가능, 2) 대각선 불가능
            if queenLocation[row] == col or rowPos - row == abs(col - queenLocation[row]):
                flag = False
                break
        if flag:
            queenLocation[rowPos] = col #퀸 놓기
            backTracking(rowPos + 1)

T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    ans = 0
    queenLocation = [0] * n
    backTracking(0) #0행부터 시작
    print(f"#{test_case} {ans}")