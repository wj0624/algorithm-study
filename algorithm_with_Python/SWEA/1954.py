#달팽이 숫자

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    snail = [[0]*N for _ in range(N)]
    #우 -> 하 -> 좌 -> 상
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]
    y, x = 0, 0
    dist = 0
    for i in range(1, N*N+1):
        snail[y][x] = i
        y += dy[dist]
        x += dx[dist]
        if y<0 or x<0 or y>=N or x>=N or snail[y][x]!=0 :
            y -= dy[dist]
            x -= dx[dist]
            dist = (dist+1)%4
            y += dy[dist]
            x += dx[dist]

    print(f"#{test_case}")
    for i in range(N):
        for j in range(N):
            print(snail[i][j], end=' ')
        print()