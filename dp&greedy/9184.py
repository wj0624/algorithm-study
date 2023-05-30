import sys

x = [[[0] * 50 for _ in range(50)] for _ in range(50)]

def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
    if(x[a][b][c]!=0):
        return x[a][b][c]
    elif a < b < c:
        x[a][b][c]=w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        x[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return x[a][b][c]

while True:
    a, b, c = map(int, sys.stdin.readline().split())
    if (a == -1 and b == -1 and c == -1):
        break
    print("w(%d, %d, %d) = %d" %(a,b,c, w(a,b,c)))