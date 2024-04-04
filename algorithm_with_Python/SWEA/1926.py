#간단한 369게임
N = int(input())

for i in range(1, N+1):
    s = str(i)
    if '3' in s or '6' in s or '9' in s :
        for j in s :
            if j == '3' or j == '6' or j == '9':
                print("-", end="")
        print(end=" ")
    else :
        print(i, end=" ")