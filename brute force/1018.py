import sys
# n, m : size of rows and columns
n, m = map(int, input().split())
board = []
cnt = []

for i in range(n):
    board.append(sys.stdin.readline().strip())
#print(board)

#체스판을 8 * 8로 자르기
for i in range(n-7):
    for j in range(m-7):
        w = 0 #W로 시작
        b = 0 #B로 시작
        #자른 범위 내에서 확인
        for k in range(i, i+8):
            for l in range(j, j+8):
                if (l+k) % 2 == 0: #index의 합이 짝수일 때는 시작하는 판과 같은 색깔
                    if board[k][l] != 'W':
                        w += 1
                    else:
                        b += 1
                else:
                    if board[k][l] != 'W':
                        b += 1
                    else:
                        w += 1
        cnt.append(w)
        cnt.append(b)
print(min(cnt))