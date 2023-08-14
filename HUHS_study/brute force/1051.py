import sys
n, m = map(int, input().split())
square = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
ans = []
for i in range(n):
    for j in range(m):
        tmp = square[i][j] #꼭짓점에 적힌 수
        for k in range(j, m):
            if tmp == square[i][k] and (i+k-j)<n:
                # (k-j) : 정사각형 한변의 길이
                if tmp == square[i+k-j][j] and tmp == square[i+k-j][k]:
                    ans.append((k-j+1)**2) #index는 0부터 시작하므로 +1 후 길이의 제곱(정사각형 크기)
print(max(ans)) #최대크기 출력
#index 초과 err -> 해당 범위 내에 있어야 한다는 조건 추가
#(i+k-j)가 주어진 행의 개수 n을 넘을 수 있음