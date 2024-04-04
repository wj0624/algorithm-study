#최대 조작횟수

T = int(input())

for test_case in range(1, T+1):
    a, b = map(int, input().split())
    ans = -1

    if a==b or (b-a)>1 : #차이가 1 이상이어야 하고, a와 b가 같을 땐 0
        ans = (b-a)//2

    print("#%d %d" %(test_case, ans))