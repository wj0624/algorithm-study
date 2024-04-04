#백만장자 프로젝트
T = int(input())

for test_case in range(1,T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    ans = 0
    high = 0
    for i in range(N-1, -1, -1):
        if arr[i] > high :
            high = arr[i]
        else :
            ans += high-arr[i]

    print(f"#{test_case} {ans}")