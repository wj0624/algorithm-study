T = 10

for test_case in range(1, T+1):
    N = int(input())
    building = list(map(int, input().split()))

    ans = 0
    for i in range(2, N-1):
        arr = building[i-2:i+3]
        m = max(arr)
        if m == building[i]:
            arr.remove(m)
            m = max(arr)
            ans += building[i] - m
    print(f"#{test_case} {ans}")