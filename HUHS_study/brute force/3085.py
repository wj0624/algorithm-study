import sys
n = int(input())
candy = [list(sys.stdin.readline().strip()) for _ in range(n)]
ans = 0

def cnt(candy):
    Max = 1
    for i in range(n):
        #행 탐색
        cnt = 1
        for j in range(1,n):
            if candy[i][j] == candy[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            Max = max(Max, cnt)
        #열 탐색
        cnt = 1
        for j in range(1,n):
            if candy[j][i] == candy[j-1][i]:
                cnt += 1
            else :
                cnt = 1
            Max = max(Max, cnt)
    return Max

for i in range(n):
    for j in range(n):
        #행 바꾸기
        if i+1 < n:
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j] #swap
            ans = max(ans, cnt(candy))
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j] #원래대로
        #열 바꾸기
        if j+1 < n:
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j] #swap
            ans = max(ans, cnt(candy))
            candy[i][j], candy[i][j + 1] = candy[i][j+1], candy[i][j] #원래대로
print(ans)